package Training.Json.Jackson.Polygon_7;

public class Square extends Polygon {
	private double side;
	public Square(){};
	public Square(double side, boolean visible) {
		super(new double[]{side, side, side, side}, visible);
	}

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setSides(double[] sides) {
        if(sides.length == getNeededNumberOfSides() && sides[0] == sides[1] && sides[1] == sides[2] &&
                sides[2] == sides[3] && sides[3] == sides[4]) {
            super.setSides(sides);
        }
    }
	@Override
	public int getNeededNumberOfSides() {
		return 4;
	}
}