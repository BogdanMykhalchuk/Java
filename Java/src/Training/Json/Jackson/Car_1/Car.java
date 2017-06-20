package Training.Json.Jackson.Car_1;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = AutoTrain.class),
	@JsonSubTypes.Type(value = Trailer.class)
})
public class Car {
	private int maxSpeed;
	private int turnAngle;
	public Car(){}
	public Car(int maxSpeed, int turnAngle) {
		this.maxSpeed = maxSpeed;
		this.turnAngle = turnAngle;
	}
	//getters/setters

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getTurnAngle() {
        return turnAngle;
    }

    public void setTurnAngle(int turnAngle) {
        this.turnAngle = turnAngle;
    }
}