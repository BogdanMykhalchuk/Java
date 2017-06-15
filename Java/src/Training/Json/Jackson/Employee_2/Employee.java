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
	//@Override
	//public String toString(){}

}
