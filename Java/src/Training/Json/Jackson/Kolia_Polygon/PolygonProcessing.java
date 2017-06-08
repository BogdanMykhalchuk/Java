package Training.Json.Jackson.Kolia_Polygon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PolygonProcessing {

    public static void main(String[] args) throws IOException {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Polygon(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0), true));
        figures.add(new Triangle(1, 2, 3, true));
        figures.add(new Square(2, true));

        System.out.println(figures.stream().max(Comparator.comparing(Figure::getPerimeter)).get().getPerimeter());
        objectsToFile("E:/test.txt", figures);
        List<Figure> figures2 = getListFromFile("E:/test.txt");
    }

    public static void objectsToFile(String filepath, List<Figure> figures) throws IOException {
        new ObjectMapper().writerFor(new TypeReference<ArrayList<Figure>>() {}).writeValue(new File(filepath), figures);
    }

    public static List<Figure> getListFromFile(String filepath) throws IOException {
        return filepath.endsWith(".txt") ?
                new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Figure>>() {}) : new ArrayList<>();
    }
}
