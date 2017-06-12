package Training.Json.Jackson.Polygon_1;

class Triangle extends Polygon {
    public Triangle(){}
    public Triangle(double[] sides, boolean visible) {
        super(sides, visible);
    }

    @Override
    public int getNeededQuantityOfSides() {
        return 3;
    }
}
