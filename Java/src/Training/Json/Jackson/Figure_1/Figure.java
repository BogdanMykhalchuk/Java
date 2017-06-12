package Training.Json.Jackson.Figure_1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.scene.shape.Circle;

@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "identifier"
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = Rectangle.class),
	@JsonSubTypes.Type(value = Circle.class)
})
public abstract class Figure {
	private Color color;
	public Figure(){}
	public Figure(Color color) {
		this.color = color;
	}
	//getter/setter
	@JsonIgnore
	public abstract double getArea();
}