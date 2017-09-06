package Training.Json.Jackson.Figure_4;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Figure {
	private List<Double> sides = new ArrayList<>();
	public Polygon(){}
	public Polygon(boolean visible, List<Double> sides) {
		super(visible);
		this.sides = sides;
	}
	//getters/setters
	@Override
	public double getPerimeter() {
		return sides.stream().reduce((a, b) -> a + b).get();
	}
}
