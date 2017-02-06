package School;

import java.io.*;
import java.util.*;

public class PupilProcession {
	public static void main(String[] args) {
	List<Pupil> listToWrite = new ArrayList<>();
	Pupil pupil1 = new PupilHighSchool("Jora", 10, new int[] {5, 4, 3, 2}, "05.06.1982", 5, "boxing");
	Pupil pupil2 = new PupilHighSchool("Gena", 8, new int[] {5, 1, 3, 2}, "11.04.1984", 6, "tennis");
	Pupil pupil3 = new PupilHighSchool("Bogdan", 9, new int[] {4, 4, 3, 2}, "23.10.1983", 5, "soccer");
	Pupil pupil4 = new PupilHighSchool("Kolia", 7, new int[] {3, 4, 3, 2}, "14.12.1985", 6, "boxing");
	Pupil pupil5 = new PupilHighSchool("Ira", 6, new int[] {2, 4, 3, 2}, "15.06.1986", 5, "soccer");
	Pupil pupil6 = new PupilJuniorSchool("Danik", 2, new int[] {3, 4, 3, 2}, "08.06.1990", 2);
	Pupil pupil7 = new PupilJuniorSchool("Yana", 1, new int[] {5, 2, 3, 2}, "12.06.1991", 1);
	Pupil pupil8 = new PupilJuniorSchool("Maria", 3, new int[] {2, 2, 3, 2}, "12.06.1989", 3);
	Pupil pupil9 = new PupilJuniorSchool("Boria", 1, new int[] {4, 4, 3, 4}, "22.08.1991", 1);
	Pupil pupil10 = new PupilJuniorSchool("Vova", 2, new int[] {5, 4, 5, 5}, "01.09.1990", 2);
	
	listToWrite.add(pupil1);
	listToWrite.add(pupil2);
	listToWrite.add(pupil3);
	listToWrite.add(pupil4);
	listToWrite.add(pupil5);
	listToWrite.add(pupil6);
	listToWrite.add(pupil7);
	listToWrite.add(pupil8);
	listToWrite.add(pupil9);
	listToWrite.add(pupil10);
	
	Collections.sort(listToWrite, new PupilComparator());
	
	for(int i = 0; i < 4; i++) {
		System.out.println(listToWrite.get(i));
	}
	
	for(int i = listToWrite.size() - 1; i > listToWrite.size() - 5; i--) {
		System.out.println(listToWrite.get(i).getBirthdayDate());
	}

	System.out.println(Arrays.toString(pupil1.getLastMarks()));

    fileToWrite(listToWrite, "D:\\Bogdan\\Job\\Java\\Kolya\\Hub\\Bogdan\\src\\com\\company\\School\\School.txt");
	//fileToRead("D:\Bogdan\Job\Java\Kolya\Hub\Bogdan\src\com\company\School\School.txt");
    }
		
	public static void fileToWrite(List<Pupil> listToWrite, String filePath){
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedReader = new BufferedWriter(fileWriter);
			
			for(Pupil object : listToWrite) {
				bufferedReader.append(object.toString());
			}
			
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
//	public static List<Pupil> fileToRead(String filePath) {
//		List<Pupil> listToRead = new ArrayList<>();
//		String fileExtension = filePath.substring(filePath.length() - 3, filePath.length());
//		if(fileExtension.equals("txt")) {
//			try {
//				FileReader fileReader = new FileReader(filePath);
//				BufferedReader bufferedReader = new BufferedReader(fileReader);
//				String s = "";
//				while(true) {
//					s = bufferedReader.readLine();
//					if(s != null) {
//						String[] arreyTemp = s.split(";");
//						if(arreyTemp.length == 6) {
//							Pupil pupil = new PupilJuniorSchool(arreyTemp[0],
//							Integer.parseInt(arreyTemp[1]), stringToArrey(arreyTemp[2]),
//							arreyTemp[4], Integer.parseInt(arreyTemp[5]));
//							listToRead.add(pupil);
//						} else {
//							Pupil pupil = new PupilHighSchool(arreyTemp[0],
//							Integer.parseInt(arreyTemp[1]), stringToArrey(arreyTemp[2]),
//							Date.parseDate(arreyTemp[4]), Integer.parseInt(arreyTemp[5]), arreyTemp[6]);
//							listToRead.add(pupil);
//						}
//					} else {
//						break;
//					}
//				}
//			} catch(IOException e) {
//				e.printStackTrace;
//			}
//			return listToRead;
//
//
//	public static int[] stringToArrey(String s) {
//		String[] tempArreyString = s.split(",");
//		int[] tempArreyInt = new int[tempArreyString.length];
//		for(int i = 0; i < tempArreyString.length; i++) {
//			tempArreyInt[i] = Integer.parseInt(tempArreyString[i]);
//		}
//		return tempArreyInt;
//	}
			
}
