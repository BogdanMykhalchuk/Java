package School;

/**
 * Created by Dreawalker on 03.10.2016.
 */
 
 public class PupilJuniorSchool extends Pupil {
	int funTime;

	public PupilJuniorSchool() {}

	public PupilJuniorSchool(String name, int classNumber, int[] lastMarks,
							 String birthDate, int funTime) {
		super(name, classNumber, lastMarks, birthDate);
		this.funTime = funTime;
	}

	public int getFunTime() {
		return funTime;
	}

	public void setFunTime(int funTime) {
		this.funTime = funTime;
	}

	@Override
	public String toString() {
		return getName() + ";" + getClassNumber() + ";" + getLastMarks()
				+ ";" + getAvarageMarks() + ";" + getBirthdayDate() + ";" + getFunTime() + "\n";
	}
}