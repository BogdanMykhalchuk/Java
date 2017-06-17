package Training.Json.Jackson.Dish_1;

public enum Type {
	MEAT(false),
	FISH(false),
	VEGETABLE(true),
	FRUIT(true),
    MILK(false);
    public boolean vegetarian;
    Type(){}
    Type(boolean vegetarian){
        this.vegetarian = vegetarian;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
}