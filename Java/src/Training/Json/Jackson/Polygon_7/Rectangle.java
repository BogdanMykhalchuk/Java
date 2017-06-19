package Training.Json.Jackson.Polygon_7;

public class Rectangle extends Polygon {
	public Rectangle(){};
	public Rectangle(double sideA, double sideB, boolean visible) {
		super(new double[]{sideA, sideB, sideA, sideB}, visible);
	}
	@Override
    public void setSides(double[] sides) {
        if(sides[0] == sides[1] && sides[2] == sides[3] || sides[0] == sides[2] && sides[1] == sides[3] ||
                sides[0] == sides[3] && sides[1] == sides[2]) {
            super.setSides(sides);
        }
    }

	@Override
	public int getNeededNumberOfSides() {
		return 4;
	}
}