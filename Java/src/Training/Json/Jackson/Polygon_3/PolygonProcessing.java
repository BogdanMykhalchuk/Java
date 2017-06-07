package Training.Json.Jackson.Polygon_3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dreawalker on 07.06.2017.
 */
@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Triangle.class, name="polygonProcessing")
})
public class PolygonProcessing {

    public List<Polygon> polygons = new ArrayList<>();

    public PolygonProcessing(){}
    public PolygonProcessing(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public static void main(String[] args) {

        PolygonProcessing polygonProcessing = new PolygonProcessing();

        polygonProcessing.polygons.add(new Triangle(new double[]{5, 6, 3}, true));
        polygonProcessing.polygons.add(new Triangle(new double[]{7, 6, 2}, true));
        polygonProcessing.polygons.add(new Triangle(new double[]{15, 6, 4}, true));

        polygonProcessing.polygons.add(new Square(new double[]{5, 5, 5, 5}, true));
        polygonProcessing.polygons.add(new Square(new double[]{4, 4, 4, 4}, true));
        polygonProcessing.polygons.add(new Square(new double[]{6, 6, 6, 6}, true));

        polygonProcessing.polygons.add(new Polygon(new double[]{15, 14, 26, 18, 47, 24, 38}, true) {
            @Override
            public int getNeededQuantityOfSides() {
                return 7;
            }
        });

        polygonProcessing.polygons.sort(new Comparator<Polygon>() {
            @Override
            public int compare(Polygon o1, Polygon o2) {
                return (int)(o2.getPerimeter() - o1.getPerimeter());
            }
        });

        Polygon figureWithBiggestPerimeter = polygonProcessing.polygons.get(0);
        figureWithBiggestPerimeter.setIsVisible(false);

        objectsToFile("D:\\Test\\List.txt", polygonProcessing);
        PolygonProcessing newPolygonProcessing = getListFromFile("D:\\Test\\List.txt");

        for(Polygon polygon : newPolygonProcessing.polygons) {
            System.out.println(polygon.getClass() + "   " + polygon.getPerimeter() + "   " + polygon.isVisible());
        }
    }

    public static void objectsToFile(String filepath, PolygonProcessing object) {
        File file = new File(filepath);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, object);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static PolygonProcessing getListFromFile(String filepath) {
        PolygonProcessing polygonProcessing = null;
        if(filepath.endsWith(".txt")) {
            File file = new File(filepath);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                polygonProcessing = objectMapper.readValue(file, PolygonProcessing.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return polygonProcessing;
    }
}
