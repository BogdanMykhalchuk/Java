package Car;

import java.text.SimpleDateFormat;

public class Machinery extends Car {
	private int maxLoad;
	
	public Machinery() {}
	
	public Machinery(String model, String dateOfProduction, int maxSpeed, int maxLoad) {
		super(model, dateOfProduction, maxSpeed);
		this.maxLoad = maxLoad;
	}
	
	public int getMaxLoad() {
		return maxLoad;
	}
	
	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}
	
	@Override
	public String getType() {
		return "Machinery";
	}
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String formattedDate = dateFormat.format(getDateOfProduction());
		return String.format("%s;%s;%d;%d;%s\n", getModel(), formattedDate, getMaxSpeed(), getMaxLoad(), getType());
	}
}