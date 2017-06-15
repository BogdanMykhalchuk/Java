package Training.Json.Jackson.Figure_2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Circle.class),
	@JsonSubTypes.Type(value = Rectangle.class)
})
public abstract class Figure {
	private Color color;
	public Figure(){};
	public Figure(Color color) {
		this.color = color;
	}
	//getter/setter;

	@JsonIgnore
	public abstract double getArea();
}