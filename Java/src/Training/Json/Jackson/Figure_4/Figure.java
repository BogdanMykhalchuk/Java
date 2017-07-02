package Training.Json.Jackson.Figure_4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Circle.class),
	@JsonSubTypes.Type(value = Rectangle.class),
	@JsonSubTypes.Type(value = Square.class),
	@JsonSubTypes.Type(value = Polygon.class),
	@JsonSubTypes.Type(value = Triangle.class),
	@JsonSubTypes.Type(value = Square.class)
})
public abstract class Figure {
	private boolean visible;
	public Figure(){}
	public Figure(boolean visible) {
		this.visible = visible;
	}
	//getters/setters
	@JsonIgnore
	public abstract double getPerimeter();
}