package Training.Json.Jackson.Fruit_1;

public class Juice {
	private Fruit fruit;
	public Juice(){}
	public Juice(Fruit fruit){
		this.fruit = fruit;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}