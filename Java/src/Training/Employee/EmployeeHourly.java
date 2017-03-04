package Training.Employee;
public class EmployeeHourly extends Employee {

    private int hourlyRate;

	public EmployeeHourly() {
	}
	
	public EmployeeHourly(String name, int id, int hourlyRate) {
		super(name, id);
		this.hourlyRate = hourlyRate;
	}
	
	private int getHourlyRate() {
		return hourlyRate;
	}
	
	public void setHourlyRate() {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double getMonthlyAvarage() {
		return hourlyRate * 20.8 * 8;
	}

	@Override
	public String toString() {
		return String.format("%s;%d;%.2f;%d\n", getName(), getId(), getMonthlyAvarage(), getHourlyRate());
	}
}