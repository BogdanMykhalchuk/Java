package Training.Json.Jackson.Students_2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = StudentPaid.class)
})

public class Student {
	private String name;
	private Map<String, Integer> marks = new HashMap<>();
	public Student(){}
	public Student(Map<String, Integer> marks, String name) {
		this.marks = marks;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
	@JsonIgnore
	public boolean isGraduated() {
		return getMarks().entrySet().stream().mapToInt(Map.Entry::getValue).average().getAsDouble() >= 3;
	}
	
}