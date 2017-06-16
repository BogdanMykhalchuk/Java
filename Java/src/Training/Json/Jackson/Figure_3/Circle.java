package Training.Json.Jackson.Figure_3;

public class Circle extends Figure {
	private double radius;
	public Circle(){}
	public Circle(Color color, double radius) {
		super(color);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}