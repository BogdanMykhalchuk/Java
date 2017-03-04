package Training.Furniture;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FurnitureShopProcessing {
	public static void main(String[] args) {
		List<FurnitureShop> listToWrite = new ArrayList<>();
		FurnitureShop worker1 = new ProductivityEmployee ("Vania", 30, 15);
		FurnitureShop worker2 = new ProductivityEmployee ("Petia", 25, 18);
		FurnitureShop worker3 = new ProductivityEmployee ("Vova", 19, 25);
		FurnitureShop worker4 = new HourlyEmployee ("Gena", 36);
		FurnitureShop worker5 = new HourlyEmployee ("Ira", 40);
		FurnitureShop worker6 = new HourlyEmployee ("Olia", 40);
		listToWrite.add(worker1);
		listToWrite.add(worker2);
		listToWrite.add(worker3);
		listToWrite.add(worker4);
		listToWrite.add(worker5);
		listToWrite.add(worker6);
		
		Collections.sort(listToWrite, new FurnitureShopComparator());
		
		for(int i = 0; i < 3; i++) {
			System.out.println(listToWrite.get(i));
		}
		
		for(int i = listToWrite.size() - 1; i > listToWrite.size() - 4; i--) {
			System.out.println(listToWrite.get(i).getName());
		}
		
		fileToWrite(listToWrite, "D:\\Job\\Java\\Kolia\\Hub\\Bogdan" +
				"\\src\\com\\company\\Training.Furniture\\Training.Furniture.txt");
		
		System.out.println(fileToRead("D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\" +
                "src\\com\\company\\Training.Furniture\\Training.Furniture.txt"));
	}
	
	public static void fileToWrite(List<FurnitureShop> list, String filePath) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for(FurnitureShop object : list) {
				bufferedWriter.append(object.toString());
			}
			
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<FurnitureShop> fileToRead(String filePath) {
		String sub = filePath.substring(filePath.length() - 3, filePath.length());
		List<FurnitureShop> list = new ArrayList<>();
		if(sub.equals("txt")) {
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String nextLine;
				while(true) {
                    nextLine = bufferedReader.readLine();
					if(nextLine != null) {
						String[] tempArray = nextLine.split(";");
						if(tempArray.length == 3) {
							FurnitureShop worker = new ProductivityEmployee(tempArray[0],
                                    Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]));
							list.add(worker);
						} else {
							FurnitureShop worker = new HourlyEmployee(tempArray[0], Integer.parseInt(tempArray[1]));
							list.add(worker);
						}
					} else {
						break;
					}
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException();
		}
		return list;
	}
}
			