package Training.School;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dreawalker on 03.10.2016.
 */
public class Pupil {

    private String name;
    private int classNumber;
    private int[] lastMarks;
    private String birthDate;

    public Pupil() {
    }

    public Pupil(String name, int classNumber, int[] lastMarks, String birthDate) {
        this.name = name;
        this.classNumber = classNumber;
        this.lastMarks = lastMarks;
        this.birthDate = birthDate;
    }

    public String getName() {
		return name;
	}
	
	public int getClassNumber() {
		return classNumber;
	}
	
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	
	public int[] getLastMarks() {

        return lastMarks;
	}
	
	public void setLastMarks(int[] lastMarks) {
		this.lastMarks = lastMarks;
	}
	
	public double getAvarageMarks() {
		double i = lastMarks[0];
		for(int j = 1; j < lastMarks.length; j++) {
			i = i + lastMarks[j];
		}
		i = i / lastMarks.length;
		return i;
	}
	
	public Date getBirthdayDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("dd.MM.yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(this.birthDate);
        } catch (ParseException e) {

        }

		return date;
	}

	public String getIntArreyToErite(int[] array) {
        String s = "";
        for(int i = 0; i < array.length; i++) {
            s = s + array[i] + ",";
        }
        return s;
    }
}