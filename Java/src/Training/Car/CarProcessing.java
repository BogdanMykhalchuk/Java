package Training.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarProcessing {
	public static void main(String[] args) {
		List<Car> listToWrite = new ArrayList<>();
		Car car1 = new Bolid("Porshe", "02.05.2015", 312, 4);
		Car car2 = new Bolid("McLaren", "05.10.2016", 322, 3);
		Car car3 = new Bolid("Bugatti", "04.09.2015", 350, 2);
		Car car4 = new Machinery("CAT", "04.07.2008", 50, 200);
		Car car5 = new Machinery("DAFF", "03.05.1994", 70, 300);
		Car car6 = new Machinery("KAMAZ", "01.01.1980", 40, 500);
        listToWrite.add(car1);
        listToWrite.add(car2);
        listToWrite.add(car3);
        listToWrite.add(car4);
        listToWrite.add(car5);
        listToWrite.add(car6);
		
		Collections.sort(listToWrite, new CarComparator());
		
		for(int i = 0; i < 3; i++) {
			System.out.println(listToWrite.get(i));
		}
		
		for(int i = listToWrite.size() - 1; i > listToWrite.size() - 4; i--) {
			System.out.println(listToWrite.get(i).getDateOfProduction());
		}
		
		fileToWrite(listToWrite, "D:\\Bogdan\\Job\\Java\\Kolya\\Hub\\Bogdan\\src\\com\\company\\Training.Car\\Training.Car.txt");
		System.out.println(fileToRead("D:\\Bogdan\\Job\\Java\\Kolya\\Hub\\Bogdan\\src\\com\\company\\Training.Car\\Training.Car.txt"));
	}
	
	public static void fileToWrite(List<Car> list, String filePath) {
		String sub = filePath.substring(filePath.length() - 3, filePath.length());
		if(sub.equals("txt")) {
            try {
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (Car object : list) {
                    bufferedWriter.append(object.toString());
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public static List<Car> fileToRead(String filePath) {
        List<Car> list = new ArrayList<>();
        try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String nextLine;
			while(true) {
				nextLine = bufferedReader.readLine();
				if(nextLine != null) {
					String[] tempArray = nextLine.split(";");
					if(tempArray[tempArray.length - 1].equals("Machinery")) {
						Car car = new Machinery(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Integer.parseInt(tempArray[3]));
						list.add(car);
					} else {
						Car car = new Bolid(tempArray[0], tempArray[1], Integer.parseInt(tempArray[2]), Integer.parseInt(tempArray[3]));
						list.add(car);
					}
				} else {
					break;
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
