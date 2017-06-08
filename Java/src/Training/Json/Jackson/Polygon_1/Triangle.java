package Training.Json.Jackson.Polygon_1;

/**
 * Created by Dreawalker on 07.06.2017.
 */
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
