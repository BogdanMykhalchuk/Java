package Swimable;

public class Amphibian extends CrossCountryVehicle {
	
	private static final String dive = "Dive";
	
	public Amphibian() {}
	
	public Amphibian(String name, int speed) {
		super(name, speed);
	}
	
	public String getDive() {
		return dive ;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s;%s;%s\n", getName(), getSpeed(), getSwim(), getDrive(), getDive());
	}
}