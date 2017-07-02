package Training.Json.Jackson.Figure_4;

public class Triangle extends Figure {
	private double sideA;
	private double sideB;
	private double sideC;
	public Triangle(){}
	public Triangle(boolean visible, double sideA, double sideB, double sideC) {
		super(visible);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	//getters/setters
	@Override
	public double getPerimeter() {
		return sideA + sideB + sideC;
	}
}
