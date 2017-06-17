package Training.Json.Jackson.Dish_2;

public enum Type {
	VEGETABLES(true),
	FRUITS(true),
	MEAT(false),
	FISH(false);
	private boolean vegetarian;
	Type(){}
	Type(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	public boolean isVegetarian() {
	    return vegetarian;
    }
}