package Training.Json.Jackson.Polygon_6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FigureProcessing {
	private static List<Figure> figures = new ArrayList<>();
	public static void main(String[] args) {
		figures.stream().max(Comparator.comparing(Figure::getPerimeter)).get().setVisible(false);
		figures.stream().mapToDouble(Figure::getPerimeter).average().getAsDouble();
		figures.sort(Comparator.comparing(Figure::getPerimeter).reversed());
		figures.forEach(System.out::println);
	}
	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Figure>>(){}).writeValue(new File(filepath), figures);
	}
	public static List<Figure> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Figure>>(){}) : new ArrayList<>();
	}
}