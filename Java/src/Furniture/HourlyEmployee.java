package Furniture;

public class HourlyEmployee extends FurnitureShop {
	private int numberOfHours;
	
	public HourlyEmployee() {}
	
	public HourlyEmployee(String name, int numberOfHours) {
		super(name);
		this.numberOfHours = numberOfHours;
	}
	
	public int getNumberOfHours() {
		return numberOfHours;
	}
	
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	
	@Override
	public int getWages() {
		return getHourlyPrice() * getNumberOfHours();
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%d\n", getName(), getNumberOfHours(), getWages());
	}
}