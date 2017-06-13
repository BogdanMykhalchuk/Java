package Training.Json.Jackson.Students_1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;
import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = StudentsPaid.class)
})

public class Students {
	private Map<String, Integer> marks = new HashMap<>();
	public Students(){}
	public Students(Map<String, Integer> marks) {
		this.marks = marks;
	}

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }
	
	@JsonIgnore
	public boolean isGraduated() {
        double i = getMarks().entrySet().stream().mapToInt(Map.Entry::getValue).average().getAsDouble();
        return i >= 3;
    }
}