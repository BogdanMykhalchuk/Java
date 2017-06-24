package Training.Json.Jackson.Car_2;

public class AutoTrain extends Car {
	double maxLoadWeight;
	public AutoTrain(){}
	public AutoTrain(int maxSpeed, int minTurnAngle, double maxLoadWight) {
		super(maxSpeed, minTurnAngle);
		this.maxLoadWeight = maxLoadWeight;
	}
}