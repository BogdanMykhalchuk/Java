package Training.Json.Jackson.Car_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarProcessing {
	private static List<Car> cars = new ArrayList<>();
	public static void main(String[] args) {
		cars.sort(Comparator.comparing(Car::getMaxSpeed));
		cars.stream().limit(3).forEach(System.out::println);
		cars.stream().skip(cars.size() - 5).forEach(System.out::println);
		Car carWithMaxSpeed = cars.stream().max(Comparator.comparing(Car::getMaxSpeed)).get();
		int minTurnAngle = cars.stream().mapToInt(Car::getTurnAngle).min().getAsInt();
	}
	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Car>>(){}).writeValue(new File(filepath), cars);
	}
	public static List<Car> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Car>>(){}) : new ArrayList<>();
	}
}