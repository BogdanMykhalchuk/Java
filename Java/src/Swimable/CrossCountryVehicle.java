package Swimable;

public class CrossCountryVehicle extends Swimable {
	
	private static final String drive = "Drive";
	
	public CrossCountryVehicle() {}
	
	public CrossCountryVehicle(String name, int speed) {
		super(name, speed);
	}
	
	public String getDrive() {
		return drive ;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s;%s\n", getName(), getSpeed(), getSwim(), getDrive());
	}
}