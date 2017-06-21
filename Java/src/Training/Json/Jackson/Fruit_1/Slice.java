package Training.Json.Jackson.Fruit_1;

public class Slice {
	private Fruit fruit;
	public Slice(){}
	public Slice(Fruit fruit){
		this.fruit = fruit;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}