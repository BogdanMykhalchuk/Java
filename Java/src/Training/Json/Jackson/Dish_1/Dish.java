package Training.Json.Jackson.Dish_1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class Dish {
	private String name;
	private double weight;
	private double price;
	private Set<Ingredient> ingredients = new HashSet<>();
	public Dish(){}
	public Dish(String name, double weight, double price, Set<Ingredient> ingredients) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	@JsonIgnore
	public boolean isVegetarian() {
        return ingredients.stream().map(Ingredient::getType).allMatch(Type::isVegetarian);
    }
    @Override
    public String toString() {
        return getName() + " " + getWeight() + " " + getPrice() + "\n" + getIngredients();
    }
}