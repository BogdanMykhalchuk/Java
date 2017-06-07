package Training.Json.Jackson.Polygon_1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Dreawalker on 07.06.2017.
 */
@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Triangle.class, name="triangle")
})
public class Triangle extends Polygon {
    public Triangle(){}
    public Triangle(double[] sides, boolean isVisible) {
        super(sides, isVisible);
    }

    @Override
    public int getNeededQuantityOfSides() {
        return 3;
    }
}
