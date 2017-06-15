package Training.Json.Jackson.Employee_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeProcessing {
	private static List<Employee> employees = new ArrayList<>();

	public static void sortMaxWagesThenDescentNames() {
		employees.sort(Comparator.comparing(Employee::getWages).redused()).thenComparing(Employee::getNames);
	}
	public static printFirstThree() {
		employees.stream().limit(3).forEach(System.out::println);
	}
	public static printLastFive() {
		employees.stream().skip(employees.size() - 5).forEach(System.out::println);
	}
	public static objectToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Employee>>(){}).writeValue(new File(filepath), employees);
	}
	public static List<Employee> getlistFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Employee>>(){}) : new ArrayList<>();
	}
}