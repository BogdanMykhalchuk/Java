package Figures;

public abstract class Figures {
	private String name;
	private String color;
	private int angles;
	
	Figures() {};
	
	Figures(String name, String color, int angles) {
		this.name = name;
		this.color = color;
		this.angles = angles;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getAngles() {
		return angles;
	}
	
	public abstract int getProduct();
	
	public abstract String getDescriptor();
}