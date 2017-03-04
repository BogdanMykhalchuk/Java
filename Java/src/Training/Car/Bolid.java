package Training.Car;

import java.text.SimpleDateFormat;

public class Bolid extends Car {
	private int speedUp;
	
	public Bolid() {}
	
	public Bolid(String model, String dateOfProduction, int maxSpeed, int speedUp) {
		super(model, dateOfProduction, maxSpeed);
		this.speedUp = speedUp;
	}
	
	public int getSpeedUp() {
		return speedUp;
	}
	
	public void setSpeedUp(int speedUp) {
		this.speedUp = speedUp;
	}
	
	@Override
	public String getType() {
		return "Bolid";
	}
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String formattedDate = dateFormat.format(getDateOfProduction());
		return String.format("%s;%s;%d;%d;%s\n", getModel(), formattedDate, getMaxSpeed(), getSpeedUp(), getType());
	}
}