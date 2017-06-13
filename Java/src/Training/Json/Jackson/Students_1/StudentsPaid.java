package Training.Json.Jackson.Students_1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

public class StudentsPaid extends Students {
	private boolean paid;
	public StudentsPaid (){}
	public StudentsPaid (Map<String, Integer> marks, boolean paid) {
		super(marks);
		this.paid = paid;
	}
	@JsonIgnore
	@Override
	public boolean isGraduated() {
		double i = getMarks().entrySet().stream().mapToInt(Map.Entry::getValue).average().getAsDouble();
		return i >= 3 && paid;
	}
}