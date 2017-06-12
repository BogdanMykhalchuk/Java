package Training.Json.Jackson.Figure_1;

public class Rectangle extends Figure {
	private double sideA;
	private double sideB;
	public Rectangle(){}
	public Rectangle(Color color, double sideA, double sideB) {
		super(color);
		this.sideA = sideA;
		this.sideB = sideB;
	}
	//getters/setters

	@Override
	public double getArea() {
		return sideA * sideB;
	}
}