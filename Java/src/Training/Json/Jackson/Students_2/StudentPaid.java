package Training.Json.Jackson.Students_2;

import java.util.Map;
public class StudentPaid extends Student {
	private boolean paid;
	public StudentPaid(){}
	public StudentPaid(Map<String, Integer> marks, String name, boolean paid) {
		super(marks, name);
		this.paid = paid;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	@Override
	public boolean isGraduated() {
		return super.isGraduated() && paid;
	}
}