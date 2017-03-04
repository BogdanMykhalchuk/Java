package Training.Swimable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwimableProcessing {
	public static void main(String[] args) {
		List<Swimable> listToWrite = new ArrayList<>();
		Swimable swim1 = new Hydroplane("Eagle", 340);
		Swimable swim2 = new Hydroplane("Arrow", 280);
		Swimable swim3 = new CrossCountryVehicle("Woolf", 110);
		Swimable swim4 = new CrossCountryVehicle("Harpy", 140);
		Swimable swim5 = new Amphibian("Tuna", 90);
		Swimable swim6 = new Amphibian("Whale", 80);
		
		listToWrite.add(swim1);
		listToWrite.add(swim2);
		listToWrite.add(swim3);
		listToWrite.add(swim4);
		listToWrite.add(swim5);
		listToWrite.add(swim6);
		
		Collections.sort(listToWrite, new SwimableComparator());
		
		for(int i = listToWrite.size() - 1; i > listToWrite.size() - 4; i--) {
			System.out.println(listToWrite.get(i).getName());
		}
		
		for(int i = 0; i < listToWrite.size() - 4; i++) {
			System.out.println(listToWrite.get(i).getSpeed());
		}
		
		writeToFile(listToWrite, "D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\" +
		"src\\com\\company\\Training.Swimable\\Training.Swimable.txt");
		
		System.out.println(readFromFile("D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\" +
		"src\\com\\company\\Training.Swimable\\Training.Swimable.txt"));
	}
	
	public static void writeToFile(List<Swimable> list, String filePath) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(Swimable object : list) {
				bufferedWriter.append(object.toString());
			}
			bufferedWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Swimable> readFromFile(String filePath) {
		List<Swimable> list = new ArrayList<>();
		String sub = filePath.substring(filePath.length() - 3, filePath.length());
		if(sub.equals("txt")) {
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while(true) {
					String nextLine = bufferedReader.readLine();
					if(nextLine != null) {
						String[] tempArray = nextLine.split(";");
						if(tempArray.length == 4 && tempArray[3].equals("Fly")) {
							Swimable object = new Hydroplane(tempArray[0],
							Integer.parseInt(tempArray[1]));
							list.add(object);
						}
						else if(tempArray.length == 4 && tempArray[3].equals("Drive")) {
							Swimable object = new CrossCountryVehicle(tempArray[0],
							Integer.parseInt(tempArray[1]));
							list.add(object);
						} else {
							Swimable object = new Amphibian(tempArray[0],
							Integer.parseInt(tempArray[1]));
							list.add(object);
						}
					} else {
						break;
					}
				}
				bufferedReader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException ();
		}
		return list;
	}
}