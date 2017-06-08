package Training.Json.Jackson.Polygon_1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Dreawalker on 07.06.2017.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "identifier"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Polygon.class),
        @JsonSubTypes.Type(value = Triangle.class),
        @JsonSubTypes.Type(value = Square.class)
})
abstract class Polygon {

    public double[] sides;
    private boolean visible;

    public Polygon(){}
    public Polygon(double[] sides, boolean visible) {
        if(sides.length == getNeededQuantityOfSides()) {
            this.sides = sides;
        }
        this.visible = visible;
    }

    public double[] getSides() {
        return sides;
    }

    public void setSides(double[] sides) {
        if(sides.length == getNeededQuantityOfSides()) {
            this.sides = sides;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    @JsonIgnore
    public double getPerimeter() {
        double perimeter = 0.0;
        for(double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    @JsonIgnore
    public abstract int getNeededQuantityOfSides();
}
