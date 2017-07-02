package Training.Json.Jackson.Figure_4;

public class Rectangle extends Figure {
	private double sideA;
	private double sideB;
	public Rectangle(){}
	public Rectangle(boolean visible, double sideA, double sideB) {
		super(visible);
		this.sideA = sideA;
		this.sideB = sideB;
	}
	//getters/setters
	@Override
	public double getPerimeter() {
		return (sideA + sideB) * 2;
	}
}
