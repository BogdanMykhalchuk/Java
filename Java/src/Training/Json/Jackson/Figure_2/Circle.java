package Training.Json.Jackson.Figure_2;

public class Circle extends Figure {
	private double radius;
	public Circle(){}
	public Circle(Color color, double radius) {
		super(color);
		this.radius = radius;
	}
	//getter/setter;

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}