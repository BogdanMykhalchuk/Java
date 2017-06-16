package Training.Json.Jackson.Figure_3;

public class Rectangle extends Figure {
	private double a;
	private double b;
	public Rectangle(){}
	public Rectangle(Color color, double a, double b) {
		super(color);
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	@Override
	public double getArea() {
		return a  * b;
	}
}