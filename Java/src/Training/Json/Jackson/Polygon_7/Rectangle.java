package Training.Json.Jackson.Polygon_7;

public class Rectangle extends Polygon {
	public Rectangle(){};
	public Rectangle(double[] sides, boolean visible) {
		super(sides, visible);
	}
	@Override
	public int getNeededNumberOfSides() {
		return 4;
	}
}