package Training.Json.Jackson.Polygon_1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dreawalker on 07.06.2017.
 */
public class PolygonProcessing {

    private static List<Polygon> polygons = new ArrayList<>();

    public static void main(String[] args) {

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

        polygons.sort(new Comparator<Polygon>() {
            @Override
            public int compare(Polygon o1, Polygon o2) {
                return (int)(o2.getPerimeter() - o1.getPerimeter());
            }
        });

        Polygon figureWithBiggestPerimeter = polygons.get(0);
        figureWithBiggestPerimeter.setIsVisible(false);

        objectsToFile("D:\\Test\\List.txt", polygons);
        List<Polygon> newPolygons = getListFromFile("D:\\Test\\List.txt");

        for(Polygon polygon : newPolygons) {
            System.out.println(polygon.getClass() + "   " + polygon.getPerimeter() + "   " + polygon.isVisible());
        }
    }

    public static void objectsToFile(String filepath, Object object) {
        File file = new File(filepath);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, object);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Polygon> getListFromFile(String filepath) {
        List<Polygon> polygons = new ArrayList<>();
        if(filepath.endsWith(".txt")) {
            File file = new File(filepath);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                polygons = objectMapper.readValue(file, ArrayList.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return polygons;
    }
}
