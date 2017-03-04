package Training.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalProcessing {
	public static void main(String[] args) {
		List<Animal> listToWrite = new ArrayList<>();
		Animal tiger = new WalkingAnimal("Tiger", 15, 22.4, 15, true);
		Animal elephant = new WalkingAnimal("Elephant", 35, 224, 10, false);
		Animal cat = new WalkingAnimal("Cat", 5, 2.4, 10, true);
		Animal dog = new WalkingAnimal("Dog", 11, 5.8, 11, false);
		Animal bear = new WalkingAnimal("Bear", 14, 64, 5, true);
		Animal duck = new FlyingAnimal("Duck", 2, 0.5, 500, true);
		Animal dove = new FlyingAnimal("Dove", 3, 0.4, 100, false);
		Animal sparrow = new FlyingAnimal("Sparrow", 1, 0.1, 50, false);
		Animal raven = new FlyingAnimal("Raven", 18, 1.5, 150, false);
		Animal eagle = new FlyingAnimal("Eagle", 7, 4, 600, false);
		
		listToWrite.add(tiger);
		listToWrite.add(elephant);
		listToWrite.add(cat);
		listToWrite.add(dog);
		listToWrite.add(bear);
		listToWrite.add(duck);
		listToWrite.add(dove);
		listToWrite.add(sparrow);
		listToWrite.add(raven);
		listToWrite.add(eagle);
		
		Collections.sort(listToWrite, new AnimalComparator());
		
		System.out.println(listToWrite);
		
		//writeToFile(listToWrite, "D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\company\\Training.Animal\\Training.Animal.txt");
		List<Animal> list = readFromFile("D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\company\\Training.Animal\\Training.Animal.txt");
        System.out.println(list);
    }
	
	
	public static void writeToFile(List<Animal> listToWrite, String filePath) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(Animal object : listToWrite) {
				bufferedWriter.append(object.toString());
			}
			bufferedWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Animal> readFromFile(String filePath) {
		String substring = filePath.substring(filePath.length() - 3, filePath.length());
        List<Animal> list = new ArrayList<>();
		if(substring.equals("txt")){
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String s = "";
				while(true) {
					s = bufferedReader.readLine();
					if(s != null) {
						String[] array = s.split(";");
						if(array[array.length - 1].equals("FlyingAnimal")) {
							Animal object = new FlyingAnimal(array[0], Integer.parseInt(array[1]),
							Double.parseDouble(array[2]), Integer.parseInt(array[3]), Boolean.valueOf(array[4]));
                            list.add(object);
						} else {
							Animal object = new WalkingAnimal(array[0], Integer.parseInt(array[1]),
							Double.parseDouble(array[2]), Integer.parseInt(array[3]), Boolean.valueOf(array[4]));
                            list.add(object);
						}
					} else {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
		
		