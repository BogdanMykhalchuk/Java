package Training.House;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class House {
	private String type;
	private int floors;
	private String wasBuild;
	
	public House() {}
	
	public House(int floors, String wasBuild) {
		this.floors = floors;
		this.wasBuild = wasBuild;
	}
	
	public int getFloors() {
		return floors;
	}
	
	public String getWasBuild() {
		return wasBuild;
	}
	
	public int getAge() {

		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy");
		Date dateOfBuild = null;
		try {
			dateOfBuild = dateFormat.parse(this.wasBuild);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date presentDate = new Date();
		long years = (presentDate.getTime() - dateOfBuild.getTime()) / 31536000000L;
		return (int)years;
	}
	
	public abstract String getType();
}
		