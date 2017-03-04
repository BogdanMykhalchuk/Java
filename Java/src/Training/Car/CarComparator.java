package Training.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
	@Override
	public int compare(Car car1, Car car2) {
		int i = car2.getMaxSpeed() - car1.getMaxSpeed();
		if(i == 0) {
			i = car1.getModel().compareTo(car2.getModel());
		}
		return i;
	}
}