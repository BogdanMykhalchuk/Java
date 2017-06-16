package Training.Json.Jackson.Figure_3;

import Training.Figures.Figures;
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
	public void objectToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Figure>>(){}).writeValue(new File(filepath), figures);
	}
	public List<Figures> getListFromFile(String filepath) throws IOException {
		return new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Figure>>(){});
	}
}