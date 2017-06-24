package Training.Json.Jackson.Car_2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Trailer.class),
	@JsonSubTypes.Type(value = AutoTrain.class)
})
public abstract class Car {
	private int maxSpeed;
	private int minTurnAngle;
	public Car(){}
	public Car(int maxSpeed, int minTurnAngle) {
		this.maxSpeed = maxSpeed;
		this.minTurnAngle = minTurnAngle;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMinTurnAngle() {
		return minTurnAngle;
	}

	public void setMinTurnAngle(int minTurnAngle) {
	    this.minTurnAngle = minTurnAngle;
	}
}