package Swimable;

import java.util.Comparator;

public class SwimableComparator implements Comparator<Swimable> {
	@Override
	public int compare(Swimable swimable1, Swimable swimable2) {
		int i = swimable2.getSpeed() - swimable1.getSpeed();
		if(i == 0) {
			i = swimable1.getName().compareTo(swimable2.getName());
		}
		return i;
	}
}