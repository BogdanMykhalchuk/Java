package Training.Json.Jackson.Polygon_6;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Figure {
	private List<Double> sides = new ArrayList<>();
	public Polygon(){}
	public Polygon(boolean visible, List<Double> sides) {
		super(visible);
		this.sides = sides;
	}
	//getter/setter
	
	public double getPerimeter() {
		return sides.stream().mapToDouble(Double::doubleValue).sum();
	}
}