package Training.Json.Jackson.Polygon_4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property  = "id")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Polygon.class),
	@JsonSubTypes.Type(value = Triangle.class),
	@JsonSubTypes.Type(value = Square.class)})

abstract class Figure {
	private boolean visible;
	public Figure(){}
	public Figure(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
        this.visible = visible;
    }
    @JsonIgnore
    public abstract double getPerimeter ();
}

class Polygon extends Figure {
	List<Double> sides = new ArrayList<>();
	public Polygon(){}
	public Polygon(List<Double> sides, boolean visible) {
		super(visible);
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

class Square extends Figure {
	private double side;
	public Square(){}
	public Square(double side, boolean visible) {
		super(visible);
		this.side = side;
	}

	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getPerimeter() {
		return side * 4;
	}
}

class Triangle extends Figure {
	private double a;
	private double b;
	private double c;
	public Triangle(){}
	public Triangle(double a, double b, double c, boolean visible) {
		super(visible);
		this.a = a;
		this.b = b;
		this.c = c;
	}

//	getters/setters;

	@Override
	public double getPerimeter() {
	return a + b + c;
	}

}

class FigureProcessing {
	public static void main(String[] args) throws IOException {
		List<Figure> figures = new ArrayList<>();
		figures.stream().max(Comparator.comparing(Figure::getPerimeter)).get().setVisible(false);
		objectToFile(figures, "D://Test//List1.txt");
		List<Figure> figuresNew = getListFromFile("D://Test//List1.txt");
	}
	public static void objectToFile(List<Figure> figures, String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<List<Figure>>() {}).writeValue(new File(filepath), figures);
	}
	public static List<Figure> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ?
			new ObjectMapper().readValue(new File(filepath), new TypeReference<List<Figure>>() {}) : new ArrayList<>();
	}
	
}
