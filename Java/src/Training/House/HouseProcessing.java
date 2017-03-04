package Training.House;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseProcessing {
	public static void main(String[] args) {
		List<House> listToWrite = new ArrayList<>();
		House house1 = new WareHouse(2, "06.10.1975", 10298);
		House house2 = new WareHouse(1, "06.09.1973", 9298);
		House house3 = new WareHouse(3, "06.10.1975", 8500);
		House house4 = new WareHouse(1, "06.11.1976", 4200);
		House house5 = new ApartmentHouse(9, "06.10.1955", 1014);
		House house6 = new ApartmentHouse(5, "12.06.1955", 1987);
		House house7 = new ApartmentHouse(3, "06.10.1954", 915);
		House house8 = new ApartmentHouse(5, "15.04.1955", 807);
		listToWrite.add(house1);
		listToWrite.add(house2);
		listToWrite.add(house3);
		listToWrite.add(house4);
		listToWrite.add(house5);
		listToWrite.add(house6);
		listToWrite.add(house7);
		listToWrite.add(house8);
		
		Collections.sort(listToWrite, new HouseComparator());
		
		for(int i = 0; i < 4; i++) {
			System.out.println(listToWrite.get(i));
		}
		
		for(int i = listToWrite.size() - 1; i > listToWrite.size() - 4; i--) {
			System.out.println(listToWrite.get(i).getAge());
		}
		
		writeToFile(listToWrite, "D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\" + 
		"company\\Training.House\\Training.House.txt");
		System.out.println(readFromFile("D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\" + 
		"company\\Training.House\\Training.House.txt"));
	}
	
	public static void writeToFile(List<House> list, String filePath) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(House object : list) {
				bufferedWriter.append(object.toString());
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<House> readFromFile(String filePath) {
		List<House> list = new ArrayList<>();
		String sub = filePath.substring(filePath.length() - 3, filePath.length());
		if(sub.equals("txt")) {
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while(true) {
					String nextLine = bufferedReader.readLine();
					if(nextLine != null) {
						String[] tempArray = nextLine.split(";");
						if(tempArray[3].equals("WareHouse")) {
							House house = new WareHouse(Integer.parseInt(tempArray[0]),
							tempArray[1], Integer.parseInt(tempArray[2]));
							list.add(house);
						} else {
							House house = new ApartmentHouse(Integer.parseInt(tempArray[0]),
							tempArray[1], Integer.parseInt(tempArray[2]));
							list.add(house);
						}
					} else {
						break;
					}
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException();
		}
		return list;
	}
}
							