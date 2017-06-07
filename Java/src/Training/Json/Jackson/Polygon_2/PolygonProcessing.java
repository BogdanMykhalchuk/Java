package Training.Json.Jackson.Polygon_2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreawalker on 07.06.2017.
 */
public class PolygonProcessing {

    private static List<Polygon> polygons = new ArrayList<>();

    public static void main(String[] args) {

        polygons.sort((o1, o2) -> (int)(o2.getPerimeter() - o1.getPerimeter()));

        Polygon figureWithBiggestPerimeter = polygons.get(0);
        figureWithBiggestPerimeter.setIsVisible(false);
    }

    public static void objectsToFile(String filepath, List<Polygon> polygons) throws IOException {
        new ObjectMapper().writeValue(new File(filepath), polygons);
    }

    public static List<Polygon> getListFromFile(String filepath) throws IOException {
        return filepath.endsWith(".txt") ?
                new ObjectMapper().readValue(new File(filepath), ArrayList.class) : new ArrayList<>();
    }
}
