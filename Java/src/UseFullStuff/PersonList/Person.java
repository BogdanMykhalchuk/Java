package UseFullStuff.PersonList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Dreawalker on 07.03.2017.
 */
public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay) {
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay) {
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public static Date stringToDate(String inputDate) {
        SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = originalFormat.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return targetFormat.format(date);
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Sex: %s; Birthday: %s", getName(), getSex(), dateToString(getBirthDay()));
    }
}
