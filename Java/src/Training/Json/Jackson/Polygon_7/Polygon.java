package Training.Json.Jackson.Polygon_7;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Triangle.class),
	@JsonSubTypes.Type(value = Rectangle.class),
	@JsonSubTypes.Type(value = Square.class)
})
public abstract class Polygon {
	private double[] sides;
	private boolean visible;
	public Polygon(){}
	public Polygon(double[] sides, boolean visible) {
		if(sides.length == getNeededNumberOfSides()) {
			this.sides = sides;
		}
		this.visible = visible;
	}

    public void setSides(double[] sides) {
        if(sides.length == getNeededNumberOfSides()) {
            this.sides = sides;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double[] getSides() {
        return sides;
    }

	@JsonIgnore
	public double getPerimeter() {
		double j = 0.0;
		for(int i = 0; i < sides.length; i++) {
			j += sides[i];
		}
		return j;
	}
	@JsonIgnore
	public abstract int getNeededNumberOfSides();
	
}