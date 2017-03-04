package Training.Employee;
public class EmployeeFixed extends Employee {

	private double salary;

	public EmployeeFixed(String name, int id, double salary) {
		super(name, id);
		this.salary = salary;
	}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
		this.salary = salary;
	}

    @Override
    public double getMonthlyAvarage() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%.2f\n", getName(), getId(), getMonthlyAvarage());
    }
}
