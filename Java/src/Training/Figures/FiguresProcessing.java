package Training.Figures;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiguresProcessing {
	public static void main(String[] args) {
		List<Figures> listToWrite = new ArrayList<>();
		Figures f1 = new PlaneFigures("Triangle", "blue", 3, 15);
		Figures f2 = new PlaneFigures("Circle", "red", 0, 28);
		Figures f3 = new PlaneFigures("Square", "yellow", 4, 11);
		Figures f4 = new SolidFigures("Sphere", "black", 0, 61);
		Figures f5 = new SolidFigures("Cube", "orange", 8, 25);
		Figures f6 = new SolidFigures("Piramide", "white", 4, 32);
		
		listToWrite.add(f1);
		listToWrite.add(f2);
		listToWrite.add(f3);
		listToWrite.add(f4);
		listToWrite.add(f5);
		listToWrite.add(f6);
		
		Collections.sort(listToWrite, new FiguresComparator());
		
		for(int i = 0; i < 4; i++) {
			System.out.println(listToWrite.get(i));
		}
		
		for(int i = listToWrite.size() - 1; i > listToWrite.size() - 4; i--) {
			System.out.println(listToWrite.get(i).getColor());
		}
		
		fileToWrite(listToWrite, "D:\\Bogdan\\Job\\Java\\Kolya\\Hub\\Bogdan\\src\\com\\company\\Training.Figures\\figures.txt");
		List<Figures> list = fileToRead("D:\\Bogdan\\Job\\Java\\Kolya\\Hub\\Bogdan\\src\\com\\company\\" +
                "Training.Figures\\figures.txt");

        System.out.println(list);
    }
	
	public static void fileToWrite(List<Figures> list, String filePath) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(Figures object : list) {
				bufferedWriter.append(object.toString());
			}
			bufferedWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Figures> fileToRead(String filePath) {
		String sub = filePath.substring(filePath.length() - 3, filePath.length());
        List<Figures> list = new ArrayList<>();
		if(sub.equals("txt")) {
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while(true) {
                    String nextLine = bufferedReader.readLine();
					if(nextLine != null) {
						String[] arreyTemp = nextLine.split(";");
						if(arreyTemp[arreyTemp.length - 1].equals("SolidFigures")) {
							Figures f = new SolidFigures(arreyTemp[0], arreyTemp[1], Integer.parseInt(arreyTemp[2]), 
							Integer.parseInt(arreyTemp[3]));
							list.add(f);							
						} else {
							Figures f = new PlaneFigures(arreyTemp[0], arreyTemp[1], Integer.parseInt(arreyTemp[2]), 
							Integer.parseInt(arreyTemp[3]));
							list.add(f);
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
			throw new IllegalArgumentException();
		}
		return list;
	}
}