package Training.Json.Jackson.Kolia_Polygon;

class Triangle extends Figure {

    private double a;
    private double b;
    private double c;

    public Triangle() { // required for json deserialization
    }

    public Triangle(double a, double b, double c, boolean isVisible) {
        super(isVisible);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
