package Figures;

import java.util.Comparator;

public class FiguresComparator implements Comparator<Figures> {
	@Override
	public int compare(Figures figure1, Figures figure2) {
		int i = figure1.getAngles() - figure2.getAngles();
		if(i == 0) {
			i = figure1.getName().compareTo(figure1.getName());
		}
		return i;
	}
}