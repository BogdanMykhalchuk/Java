package Training.Json.Jackson.Polygon_5;

public class Square extends Figure {
	private double a;

	public Square(){}
	public Square(boolean visible, double a) {
		super(visible);
		this.a = a;

	}

	//getters/seters;

	@Override
	public double getPerimeter() {
		return a * 4;
	}
}