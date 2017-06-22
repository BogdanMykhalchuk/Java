package Training.Json.Jackson.Employee_5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StuffProcessing {
	private static List<Stuff> stuff = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 5; i++) {
            stuff.add(new Employee("Petia" + i, (Math.random() * 10 + 20) + (Math.random() * 15 + 5)));
        }
		for(int i = 0; i < 5; i++) {
            stuff.add(new Manager("Vasia" + i, (Math.random() * 10 + 20) + (Math.random() * 15 + 5)));
        }
		stuff.sort(Comparator.comparing(Stuff::getWages).thenComparing((a, b) -> b.getName().compareTo(a.getName())));
		stuff.stream().limit(3).forEach(System.out::println);
        System.out.println();
        stuff.stream().skip(stuff.size() - 5).forEach(System.out::println);
		Stuff stuffMaxWages = stuff.stream().max(Comparator.comparing(Stuff::getWages)).get();
        System.out.println();
        System.out.println(stuffMaxWages);
        listToFile("D:\\Test\\Employee.txt");
        List<Stuff> newStuff = getListFromFile("D:\\Test\\Employee.txt");
        System.out.println();
        newStuff.forEach(System.out::println);

    }
	public static void listToFile(String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<ArrayList<Stuff>>(){}).writeValue(new File(filepath), stuff);
	}
	public static List<Stuff> getListFromFile(String filepath) throws IOException {
		return filepath.endsWith(".txt") ? new ObjectMapper().readValue(new File(filepath), new TypeReference<ArrayList<Stuff>>(){}) : new ArrayList<>();
	}
}