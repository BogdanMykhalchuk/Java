package Training.Swimable;

public class Swimable {
    private String name;
	private static final String swim = "Swim";
	private int speed;
	
	public Swimable() {}
	
	public Swimable(String name, int speed) {
		this.name = name;
        this.speed = speed;
	}

	public String getName() {
        return name;
    }
	
	public String getSwim() {
		return swim;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}