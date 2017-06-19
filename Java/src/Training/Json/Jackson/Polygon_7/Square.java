package Training.Json.Jackson.Polygon_7;

public class Square extends Polygon {
	public Square(){};
	public Square(double side, boolean visible) {
		super(new double[]{side, side, side, side}, visible);
	}

    @Override
    public void setSides(double[] sides) {
        if(sides.length == getNeededNumberOfSides() && sides[0] == sides[1] && sides[1] == sides[2] &&
                sides[2] == sides[3]) {
            super.setSides(sides);
        }
    }
	@Override
	public int getNeededNumberOfSides() {
		return 4;
	}
}