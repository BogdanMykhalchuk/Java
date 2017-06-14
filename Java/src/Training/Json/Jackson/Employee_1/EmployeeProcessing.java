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
	
	public static void main(String[] args) throws IOException {
		List<Employee> employees = new ArrayList<>();
		for(int i = 1; i <= 20; i++) {
			employees.add(new Employee("Petia" + i, "Petrov" + i, (Math.random() * 10 + 24) + (Math.random() * 20 + 36)));
		}
        employees.add(new Employee("Anton", "Atamanov", 23413.45));
        employees.add(new Employee("Aleksandr", "Agatov", 23413.45));
        employees.add(new Employee("Artem", "Arbuzov", 23413.45));

		employees.forEach(System.out::println);
        System.out.println();
        System.out.println();

        sortEmployee(employees);

        employees.forEach(System.out::println);
        System.out.println();
        System.out.println();

        System.out.println("Employee with max salary: " + getEmployeeWithMaxSalary(employees));
        System.out.println();
        System.out.println();

        System.out.println("Employee with min hourly rate: " + getEmployeeWithMinHourlyRate(employees));
        System.out.println();
        System.out.println();

        System.out.println(String.format("Average salary: %.2f", getAverageSalary(employees)));
        System.out.println();
        System.out.println();

        System.out.println("Employees with salary higher then average:");
        printHigherSalaryThanAverage(employees);
        System.out.println();
        System.out.println();

        System.out.println("Names of all employees:");
        printAllNames(employees);
        System.out.println();
        System.out.println();

        System.out.println("Employee who's last name starts with \'A\':");
        getEmploeeWhosNamesStartsWithA(employees).forEach(System.out::println);
        System.out.println();
        System.out.println();

        System.out.println("Last names of Employees who's name starts with \'A\':");
        printLastNamesWhosNamesStartsWithA(employees);
        System.out.println();
        System.out.println();

        System.out.println("Salary of first three employees:");
        printSalaryOfFirstThree(employees);
        System.out.println();
        System.out.println();

        System.out.println("Salary of last five employees:");
        printSalaryOfLastFive(employees);
        System.out.println();
        System.out.println();

        objectToFile("D:\\Test\\Employee.txt", employees);
        List<Employee> newEmployees = readListFromFile("D:\\Test\\Employee.txt");
        System.out.println("New list of Employees:");
        newEmployees.forEach(System.out::println);
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
	public static List<Employee> getEmploeeWhosNamesStartsWithA(List<Employee> employees) {
		return employees.stream().filter(e -> e.getFirstName().startsWith("A")).collect(Collectors.toList());
	}
    public static void printLastNamesWhosNamesStartsWithA(List<Employee> employees) {
        employees.stream().filter(e -> e.getFirstName().startsWith("A")).map(Employee::getLastName).forEach(System.out::println);
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