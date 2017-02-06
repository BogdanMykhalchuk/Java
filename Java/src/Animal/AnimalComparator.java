package Animal;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal animal1, Animal animal2) {
		int i = (int)(animal1.getWeight() - (animal2.getWeight()));
		return i;
	}
}