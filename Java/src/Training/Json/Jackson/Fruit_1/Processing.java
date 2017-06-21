package Training.Json.Jackson.Fruit_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Processing {
	public static List<Fruit> fruits = new ArrayList<>();
	public static void main(String[] args) {
		fruits.sort(Comparator.comparing(Fruit::getName));
		fruits.stream().limit(3).forEach(System.out::println);
		fruits.stream().skip(fruits.size() - 5).forEach(System.out::println);
	}

	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Fruit>>(){}).writeValue(new File(filepath), fruits);
	}

	public static List<Fruit> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Fruit>>(){}) : new ArrayList<>();
	}
}