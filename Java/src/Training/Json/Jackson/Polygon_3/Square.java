package Training.Json.Jackson.Polygon_3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Dreawalker on 07.06.2017.
 */
@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= Square.class, name="square"),
})
public class Square extends Polygon {

    public Square(){}
    public Square(double[] sides, boolean isVisible) {
        super(sides, isVisible);
    }

    @Override
    public int getNeededQuantityOfSides() {
        return 4;
    }

}
