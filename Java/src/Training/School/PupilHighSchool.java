package Training.School;

/**
 * Created by Dreawalker on 03.10.2016.
 */
 
 public class PupilHighSchool extends Pupil {
	private int numberOfLessons;
	private String section;

	public PupilHighSchool() {}

	public PupilHighSchool(String name, int classNumber, int[] lastMarks,
						   String birthDate, int numberOfLessons, String section) {
		super(name, classNumber, lastMarks, birthDate);
		this.numberOfLessons = numberOfLessons;
		this.section = section;
	}

	public int getNumberOfLessons() {
		return numberOfLessons;
	}

	public void setNumberOfLessons(int numberOfLessons) {
		this.numberOfLessons = numberOfLessons;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return getName() + ";" + getClassNumber() + ";" + getLastMarks()
				+ ";" + getAvarageMarks() + ";" + getBirthdayDate() + ";"
				+ getNumberOfLessons() + ";" + getSection() + "\n";
	}
}