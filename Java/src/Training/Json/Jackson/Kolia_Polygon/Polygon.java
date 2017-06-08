package Training.Json.Jackson.Kolia_Polygon;

import java.util.ArrayList;
import java.util.List;

class Polygon extends Figure {

    private List<Double> sides = new ArrayList<>();

    public Polygon() { // required for json deserialization
    }

    public Polygon(List<Double> sides, boolean isVisible) {
        super(isVisible);
        this.sides = sides;
    }

    public List<Double> getSides() {
        return sides;
    }

    public void setSides(List<Double> sides) {
        this.sides = sides;
    }

    @Override
    public double getPerimeter() {
        return sides.stream().reduce((a, b) -> a + b).get();
    }
}
