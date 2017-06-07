package Training.Json.Jackson.Polygon_2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by Dreawalker on 07.06.2017.
 */
@JsonAutoDetect
abstract class Polygon {

    public double[] sides;
    private boolean isVisible;

    public Polygon(){}
    public Polygon(double[] sides, boolean isVisible) {
        if(sides.length == getNeededQuantityOfSides()) {
            this.sides = sides;
        }
        this.isVisible = isVisible;
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
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public double getPerimeter() {
        double perimeter = 0.0;
        for(double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    public abstract int getNeededQuantityOfSides();
}
