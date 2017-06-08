package Training.Json.Jackson.Kolia_Polygon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
public abstract class Figure {

    private boolean isVisible;

    public Figure() {} // required for json deserialization

    public Figure(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @JsonIgnore
    public abstract double getPerimeter();
}
