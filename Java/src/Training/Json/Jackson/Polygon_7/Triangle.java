package Training.Json.Jackson.Polygon_7;

public class Triangle extends Polygon {
	public Triangle(){};
	public Triangle(double[] sides, boolean visible) {
		super(sides, visible);
	}
	@Override
	public int getNeededNumberOfSides() {
		return 3;
	}
}