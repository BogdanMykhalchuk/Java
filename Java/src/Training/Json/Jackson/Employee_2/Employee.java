package Training.Json.Jackson.Employee_2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Manager.class)
})
public class Employee {
	private String name;
	private double wages;
	public Employee(){}
	public Employee(String name, double wages) {
		this.name = name;
		this.wages = wages;
	}

	//getters/setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}
	//@Override
	//public String toString(){}

}
