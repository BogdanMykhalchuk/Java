package Training.School;

import java.util.Comparator;

public class PupilComparator implements Comparator<Pupil> {

    @Override
    public int compare(Pupil pupil1, Pupil pupil2) {
		int i = (int) (pupil1.getAvarageMarks() - pupil2.getAvarageMarks());
		if(i == 0) {
			i = pupil1.getName().compareTo(pupil2.getName());
		}
		
		return i;
	}
}