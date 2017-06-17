package Training.Json.Jackson.Dish_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Menu {
	private static List<Dish> dishes = new ArrayList<>();
	public static void main(String[] args) throws IOException {
        Set<Ingredient> ingredientSet1 = new HashSet<>();
        ingredientSet1.add(new Ingredient("apple", Type.FRUIT));
        ingredientSet1.add(new Ingredient("grape", Type.FRUIT));
        ingredientSet1.add(new Ingredient("apricot", Type.FRUIT));
        ingredientSet1.add(new Ingredient("orange", Type.FRUIT));
        Dish fruitSalad = new Dish("Fruit salad", 150, 70, ingredientSet1);

        Set<Ingredient> ingredientSet2 = new HashSet<>();
        ingredientSet2.add(new Ingredient("potato", Type.VEGETABLE));
        ingredientSet2.add(new Ingredient("carrot", Type.VEGETABLE));
        ingredientSet2.add(new Ingredient("sausage", Type.MEAT));
        Dish olivie = new Dish("Sausage salad", 250, 170, ingredientSet2);

        Set<Ingredient> ingredientSet3 = new HashSet<>();
        ingredientSet3.add(new Ingredient("onion", Type.VEGETABLE));
        ingredientSet3.add(new Ingredient("carrot", Type.VEGETABLE));
        ingredientSet3.add(new Ingredient("fish", Type.FISH));
        Dish friedFish = new Dish("Fried fish", 250, 170, ingredientSet3);

        Set<Ingredient> ingredientSet4 = new HashSet<>();
        ingredientSet4.add(new Ingredient("cream", Type.MILK));
        ingredientSet4.add(new Ingredient("sugar", Type.VEGETABLE));
        Dish iceCream = new Dish("Ice cream", 250, 170, ingredientSet4);

        dishes.add(fruitSalad);
        dishes.add(olivie);
        dishes.add(friedFish);
        dishes.add(iceCream);
        printVegetarianNames();
        listToFile("D:\\Test\\Dishes.txt");
        List<Dish> newDishes = getListFromFile("D:\\Test\\Dishes.txt");
        dishes = newDishes;
        printVegetarianNames();
        dishes.forEach(System.out::println);
    }
	public static void sortListHigherPriceBiggerWeight() {
		dishes.sort(Comparator.comparing(Dish::getPrice).reversed().thenComparing(Dish::getWeight).reversed());
	}
	public static void printVegetarianNames() {
		dishes.stream().filter(Dish::isVegetarian).map(Dish::getName).forEach(System.out::println);
	}
	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Dish>>(){}).writeValue(new File(filepath), dishes);
	}
	public static List<Dish> getListFromFile(String filepath) throws IOException {
		return new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Dish>>(){});
	}
}