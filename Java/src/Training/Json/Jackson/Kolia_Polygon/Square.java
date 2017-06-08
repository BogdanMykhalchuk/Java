package Training.Json.Jackson.Kolia_Polygon;

public class Square extends Figure {

    private double a;

    public Square() { // required for json deserialization
    }

    public Square(double a, boolean isVisible) {
        super(isVisible);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double getPerimeter() {
        return a * 4;
    }
}
