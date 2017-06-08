package Training.Json.Jackson.Polygon_1;

/**
 * Created by Dreawalker on 07.06.2017.
 */
class Square extends Polygon {

    public Square(){}
    public Square(double[] sides, boolean visible) {
        super(sides, visible);
    }

    @Override
    public int getNeededQuantityOfSides() {
        return 4;
    }

}
