package Training.Json.Jackson.Dish_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {
	private static List<Dish> dishes = new ArrayList<>();
	public static void sortHighPriceThenHeavyWeight() {
		dishes.sort(Comparator.comparing(Dish::getPrice).reversed().thenComparing(Dish::getWeight).reversed());
	}
	public static void printVegetarianDishes() {
		dishes.stream().filter(Dish::isVegetarian).forEach(System.out::println);
	}
	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Dish>>(){}).writeValue(new File(filepath), dishes);
	}
	public static List<Dish> getListFromFile(String filepath) throws IOException {
		return new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Dish>>(){});
	}
	public static Dish getMostExpensiveDish() {
		return dishes.stream().max(Comparator.comparing(Dish::getPrice)).get();
	}
	public static Dish getLitesWeight() {
		return dishes.stream().min(Comparator.comparing(Dish::getWeight)).get();
	}
	public static void setPriceInDollarsForVegetarian(double exchangeRate) {
		dishes.stream().filter(a -> !a.isVegetarian()).forEach(a -> a.setPrice(a.getPrice() * exchangeRate));
	}
	public static double getAveragePrice() {
		return dishes.stream().mapToDouble(Dish::getPrice).average().getAsDouble();
	}
	public static int getMinNumberOfIngredients() {
		return dishes.stream().min(Comparator.comparing(Dish::getIngredientsNumber)).get().getIngredientsNumber();
	}
	public static double getNumberOfIngredientInDishesStartsWithBandFinishesWithI() {
		return dishes.stream().filter(a -> a.getName().startsWith("B") && a.getName().endsWith("i")).mapToInt(Dish::getIngredientsNumber).sum();
	}
	public static boolean isThereEqualsSetsWithIngredients() {
		List<Set<Ingredient>> list1 = dishes.stream().map(Dish::getIngredients).collect(Collectors.toList());
        List<Set<Ingredient>> list2 = new ArrayList<>(list1);
		for(int i = 0; i < list1.size(); i++) {
		    for(int j = i + 1; j < list2.size(); j++) {
                if(list1.get(i).size() == list2.get(j).size() && list1.get(i).containsAll(list2.get(j))) {
                    return true;
                }
            }
        }
		return false;
	}
	public static void setNamesAccordingContainingMeatOrFish() {
		dishes.stream().filter(Dish::isContainsFish).forEach(a -> a.setName(a.getName() + "FISH"));
		dishes.stream().filter(Dish::isContainsMeat).forEach(a -> a.setName("MEAT" + a.getName()));
	}
	public static Dish getMostPopularDish() {
		return dishes.stream().max(Comparator.comparing(Dish::getCount)).get();
	}
}