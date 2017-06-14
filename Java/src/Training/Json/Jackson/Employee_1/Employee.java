package Training.Json.Jackson.Employee_1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect

public class Employee {
	private String firstName;
	private String lastName;
	private double hourlyRate;
	public Employee(){}
	public Employee(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@JsonIgnore
	public double getSalary() {
		return 21 * 8 * hourlyRate;
	}

	public String toString() {
		return String.format("Name: %s, Surname: %s, Wages: %.2f", firstName, lastName, getSalary());
	}
}