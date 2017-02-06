package Furniture;

import java.util.Comparator;

public class FurnitureShopComparator implements Comparator<FurnitureShop> {
	@Override
	public int compare(FurnitureShop object1, FurnitureShop object2) {
		int i = object2.getWages() - object1.getWages();
		if(i == 0) {
			i = object1.getName().compareTo(object2.getName());
		}
		return i;
	}
}