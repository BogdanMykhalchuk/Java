package Training.Json.Jackson.Employee_4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProcessing {
	private static List<Employee> employees = new ArrayList<>();
	public static Employee getMaxSelary() {
		return employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
	}
	public static Employee getMinHourlyRate() {
		return employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
	}
	public static void sortEmployees() {
		employees.sort((Comparator.comparing(Employee::getHourlyRate).reversed()).thenComparing(Employee::getLastName));
	}
	public static double getAverageSalary() {
		return employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
	}
	public static void printSalaryHigherThenAverage() {
		employees.stream().filter(a -> getAverageSalary() < a.getSalary()).forEach(System.out::println);
	}
	public static void printAllNames() {
		employees.stream().map(Employee::getFirstName).forEach(System.out::println);
	}
	public static List<String> getListOfLastNamesWithNamesStartsWithA() {
		return employees.stream().filter(a -> a.getFirstName().startsWith("A")).map(Employee::getLastName).collect(Collectors.toList());
	}
	public static void printSalaryOfFirstThree() {
		employees.stream().limit(3).mapToDouble(Employee::getSalary).forEach(System.out::println);
	}
	public static void printSalaryOfLastFife() {
		employees.stream().skip(employees.size() - 5).mapToDouble(Employee::getSalary).forEach(System.out::println);
	}
	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Employee>>(){}).writeValue(new File(filepath), employees);
	}
	public static List<Employee> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Employee>>(){}) : new ArrayList<>();
	}
}