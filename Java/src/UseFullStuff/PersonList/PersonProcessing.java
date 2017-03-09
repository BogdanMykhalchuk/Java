package UseFullStuff.PersonList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static UseFullStuff.PersonList.Person.createFemale;
import static UseFullStuff.PersonList.Person.createMale;
import static UseFullStuff.PersonList.Person.stringToDate;

/**
 * Created by Dreawalker on 07.03.2017.
 */
public class PersonProcessing {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                if (args[2].equals("м")) {
                    allPeople.add(createMale(args[1], stringToDate(args[3])));
                } else if (args[2].equals("ж")) {
                    allPeople.add(createFemale(args[1], stringToDate(args[3])));
                }
                System.out.println(allPeople.size() - 1);
                for(Person person : allPeople) {
                    System.out.println(person.toString());
                }
                break;
            case "-u":
                if (args[3].equals("м")) {
                    allPeople.set(Integer.parseInt(args[1]), createMale(args[2], stringToDate(args[4])));
                } else if (args[3].equals("ж")) {
                    allPeople.set(Integer.parseInt(args[1]), createFemale(args[2], stringToDate(args[4])));
                }
                for(Person person : allPeople) {
                    System.out.println(person.toString());
                }
                break;
            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                allPeople.remove(Integer.parseInt(args[1]));
                for(Person person : allPeople) {
                    System.out.println(person.toString());
                }
                break;
            case "-i":
                System.out.println(allPeople.get(Integer.parseInt(args[1])).toString());
                break;
        }
    }
}
