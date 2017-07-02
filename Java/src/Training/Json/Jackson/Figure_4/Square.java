package Training.Json.Jackson.Figure_4;

public class Square extends Figure {
	private double side;
	public Square(){}
	public Square(boolean visible, double side) {
		super(visible);
		this.side = side;
	}
	//getters/setters
	@Override
	public double getPerimeter() {
		return side * 4;
	}
}
