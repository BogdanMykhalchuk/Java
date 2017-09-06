package Training.Json.Jackson.Figure_4;

public class Circle extends Figure {
	private double radius;
	public Circle(){}
	public Circle(boolean visible, double radius) {
		super(visible);
		this.radius = radius;
	}
	//getters/setters
	@Override
	public double getPerimeter() {
		return radius * radius * Math.PI;
	}
}
