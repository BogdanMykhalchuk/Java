package Training.Json.Jackson.Figure_4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dreawalker on 02.07.2017.
 */
public class FigureProcessing {
    private static List<Figure> figures = new ArrayList<>();
    public static void main(String[] args) {
        figures.sort(Comparator.comparing(Figure::getPerimeter).reversed());
        figures.stream().limit(3).forEach(System.out::println);
        figures.stream().skip(figures.size() - 5).forEach(System.out::println);
        double averagePerimeter = figures.stream().mapToDouble(Figure::getPerimeter).average().getAsDouble();
    }
    public static void listToFile(String filepath) throws IOException {
        new ObjectMapper().writerFor(new TypeReference<ArrayList<Figure>>(){}).writeValue(new File(filepath), figures);
    }
    public static List<Figure> getListFromFile(String filepath) throws IOException {
        return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Figure>>(){}) : new ArrayList<>();
    }

}