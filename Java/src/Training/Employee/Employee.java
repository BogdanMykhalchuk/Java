package Training.Employee;

import java.io.Serializable;

public abstract class Employee implements Serializable{
	private String name;
	private int id;

	public Employee() {
	}
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public abstract double getMonthlyAvarage();
}