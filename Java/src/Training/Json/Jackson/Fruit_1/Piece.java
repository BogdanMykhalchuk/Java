package Training.Json.Jackson.Fruit_1;

public class Piece {
	private Fruit fruit;
	public Piece(){}
	public Piece(Fruit fruit){
		this.fruit = fruit;
	}
	
	public Fruit getFruit() {
		return fruit;
	}
	
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}