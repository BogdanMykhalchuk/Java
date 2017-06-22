package Training.Json.Jackson.Employee_5;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Manager.class),
	@JsonSubTypes.Type(value = Employee.class)
})
public abstract class Stuff {
	private String name;
	private double wages;
	public Stuff(){}
	public Stuff(String name, double wages) {
		this.name = name;
		this.wages = wages;
	}
	public String getName() {
		return name;
	}
	public void setNmae(String name) {
		this.name = name;
	}
	public double getWages() {
		return wages;
	}
	public void setWages(double wages) {
		this.wages = wages;
	}
	@Override
	public String toString() {
		return String.format("Class: %s; Name: %s; Wages: %.2f", getClass().getSimpleName(), getName(), getWages());
	}
	
}