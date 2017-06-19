package Training.Json.Jackson.Polygon_6;

public class Triangle extends Figure {
	private double a;
	private double b;
	private double c;
	public Triangle(){}
	//constructor with parameters
	//getters/setters
	
	public double getPerimeter() {
		return a + b + c;
	}
}