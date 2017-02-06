package House;

import java.util.Comparator;

public class HouseComparator implements Comparator<House> {
	@Override
	public int compare(House house1, House house2) {
		int i = house2.getAge() - house1.getAge();
		if(i == 0) {
			i = house1.getType().compareTo(house2.getType());
		}
		return i;
	}
}