package Animal;

public abstract class Animal {
	private String name;
	private int age;
	private double height;
	
	public Animal() {}
	
	public Animal(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double age) {
		this.height = height;
	}
	
	public double getWeight() {
		return age * height;
	}
	
	public abstract String getDiscriminator();
}