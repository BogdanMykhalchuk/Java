package Car;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Car {
	private String model;
	private String dateOfProduction;
	private int maxSpeed;
	
	public Car(){}
	
	public Car(String model, String dateOfProduction, int maxSpeed) {
		this.model = model;
		this.dateOfProduction = dateOfProduction;
		this.maxSpeed = maxSpeed;
	}
	
	public String getModel() {
		return model;
	}
	
	public Date getDateOfProduction() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(this.dateOfProduction);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public abstract String getType();
}