package Training.Json.Jackson.Polygon_5;

public class Triangle extends Figure {
	private double a;
	private double b;
	private double c;
	public Triangle(){}
	public Triangle(boolean visible, double a, double b, double c) {
		super(visible);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	//getters/seters;

	@Override
	public double getPerimeter() {
		return a + b + c;
	}
}