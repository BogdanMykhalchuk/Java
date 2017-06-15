package Training.Json.Jackson.Figure_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Plane {
	private static List<Figure> figures = new ArrayList<>();
	public static double getAverageArea() {
		return figures.stream().mapToDouble(Figure::getArea).average().getAsDouble();
	}
	public void objectToFile(Figure figure, String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<Figure>(){}).writeValue(new File(filepath), figure);
	}
	public Figure getFigureFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<Figure>(){}) : null;
	}
}