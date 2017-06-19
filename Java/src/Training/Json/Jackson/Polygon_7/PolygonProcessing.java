package Training.Json.Jackson.Polygon_7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PolygonProcessing {
	private static List<Polygon> polygons = new ArrayList<>();
	public static void main(String[] args) {
		polygons.stream().max(Comparator.comparing(Polygon::getPerimeter)).get().setVisible(false);
	}

	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Polygon>>(){}).writeValue(new File(filepath), polygons);
	}
	public static List<Polygon> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Polygon>>(){}) : new ArrayList<>();
	}
}