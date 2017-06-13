package Training.Json.Jackson.Employee_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProcessing {
	
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			employees.add(new Employee("Petia" + i, "Petrov" + i, (Math.random() * 10 + 24) + (Math.random() * 20 + 36)));
		}
	}
	public static Employee getEmployeeWithMaxSalary(List<Employee> employees) {
		return employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
	}
	public static Employee getEmployeeWithMinHourlyRate(List<Employee> employees) {
		return employees.stream().min(Comparator.comparing(Employee::getHourlyRate)).get();
	}
	public static void sortEmployee(List<Employee> employees) {
		employees.sort((Comparator.comparing(Employee::getHourlyRate).reversed()).thenComparing(Employee::getLastName));
	}
	public static double getAverageSalary(List<Employee> employees) {
		return employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
	}
	public static void printHigherSalaryThanAverage(List<Employee> employees) {
		employees.stream().filter(e -> e.getSalary() > getAverageSalary(employees)).forEach(System.out::println);
	}
	public static void printAllNames(List<Employee> employees) {
		employees.stream().map(Employee::getFirstName).forEach(System.out::println);
	}
	public static List<Employee> getLastNamesWhosNamesStartsWithA(List<Employee> employees) {
		List<Employee> newList = new ArrayList<>();
		employees.stream().filter(e -> e.getFirstName().startsWith("A")).collect(Collectors.toList());
		return newList;
	}
	public static void printSalaryOfFirstThree(List<Employee> employees) {
		employees.stream().limit(3).map(Employee::getSalary).forEach(System.out::println);
	}
	public static void printSalaryOfLastFive(List<Employee> employees) {
		employees.stream().skip(employees.size() - 5).map(Employee::getSalary).forEach(System.out::println);
	}
	public static void objectToFile(String filepath, List<Employee> employees) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Employee>>(){}).writeValue(new File(filepath), employees);
	}
	public static List<Employee> readListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Employee>>(){}) : new ArrayList<>();
	}
}