package Training.Json.Jackson.Polygon_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@JsonIgnoreProperties({"identifier"})
@JsonDeserialize(as = Polygon.class)

class PolygonProcessing {

    public static void main(String[] args) throws IOException {

        List<Polygon> polygons = new ArrayList<>();

        polygons.add(new Triangle(new double[]{5, 6, 3}, true));
        polygons.add(new Triangle(new double[]{7, 6, 2}, true));
        polygons.add(new Triangle(new double[]{15, 6, 4}, true));

        polygons.add(new Square(new double[]{5, 5, 5, 5}, true));
        polygons.add(new Square(new double[]{4, 4, 4, 4}, true));
        polygons.add(new Square(new double[]{6, 6, 6, 6}, true));

        polygons.add(new Polygon(new double[]{15, 14, 26, 18, 47, 24, 38}, true) {
            @Override
            public int getNeededQuantityOfSides() {
                return 7;
            }
        });

        polygons.add(new Polygon(new double[]{13, 15, 14, 26, 18, 47, 24, 38}, true) {
            @Override
            public int getNeededQuantityOfSides() {
                return 8;
            }
        });

        polygons.sort((o1, o2) -> {
            int i = new Double(o1.getPerimeter()).compareTo(new Double(o2.getPerimeter()));
            if(i == 0) {
                i = o2.getName().compareTo(o1.getName());
            }
            return i;
        });

        Polygon figureWithBiggestPerimeter = polygons.get(0);
        figureWithBiggestPerimeter.setVisible(false);

        objectsToFile("D:\\Test\\List.txt", polygons);
        List<Polygon> newPolygons = getListFromFile("D:\\Test\\List.txt");

        for(Polygon polygon : newPolygons) {
            System.out.println(polygon.getClass() + "   " + polygon.getPerimeter() + "   " + polygon.isVisible());
        }
    }

    public static void objectsToFile(String filepath, List<Polygon> polygons) throws IOException {
        new ObjectMapper().writerFor(new TypeReference<ArrayList<Polygon>>() {}).writeValue(new File(filepath), polygons);
    }

    public static List<Polygon> getListFromFile(String filepath) throws IOException {
        ObjectMapper objectMapper =  new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return filepath.endsWith(".txt") ?
                objectMapper.readValue(new File(filepath), new TypeReference<ArrayList<Polygon>>() {}) : new ArrayList<>();
    }
}
