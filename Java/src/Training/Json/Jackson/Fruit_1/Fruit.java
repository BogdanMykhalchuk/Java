package Training.Json.Jackson.Fruit_1;

import java.util.ArrayList;
import java.util.List;

public class Fruit {
	private String name;
	private Juice juice;
	private List<Piece> pieces = new ArrayList<>();
	public Fruit(){}
	public Fruit(String name, Juice juice, List<Piece> pieces) {
		this.name = name;
		this.juice = juice;
		this.pieces = pieces;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Juice getJuice() {
		return juice;
	}
	public void detJuice(Juice juice) {
		this.juice = juice;
	}
	public List<Piece> getPieces() {
		return pieces;
	}
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
}