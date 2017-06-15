package Training.Json.Jackson.Figure_2;

public class Rectangle extends Figure {
	private double a;
	private double b;
	public Rectangle(){}
	public Rectangle(Color color, double a, double b) {
		super(color);
		this.a = a;
		this.b = b;
	}
	//getter/setter;

	@Override
	public double getArea() {
		return a * b;
	}
}