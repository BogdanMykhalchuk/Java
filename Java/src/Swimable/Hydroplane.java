package Swimable;

public class Hydroplane extends Swimable {
	
	private static final String fly = "Fly";
	
	public Hydroplane() {}
	
	public Hydroplane(String name, int speed) {
		super(name, speed);
	}
	
	public String getFly() {
		return fly;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s;%s\n", getName(), getSpeed(), getSwim(), getFly());
	}
}