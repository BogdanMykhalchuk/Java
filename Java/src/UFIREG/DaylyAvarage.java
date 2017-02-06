package UFIREG;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;

/**
 * Created by Dreawalker on 09.10.2016.
 */
public class DaylyAvarage {
    private static int date;
    private static String filePath = "D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\company\\UFIREG\\UFIREG_August.txt";
    private static List<Double> list = new ArrayList<>();
    public static FileWriter fileWriter;
    public static BufferedWriter bufferedWriter;
    public static FileReader fileReader;
    public static BufferedReader bufferedReader;

    public static void main(String[] args) {

        try {
            fileWriter = new FileWriter("D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\company\\UFIREG\\Test.Test.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            calculation();
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }

    public static int getDate() {
        return date;
    }

    public static void setDate(int date) {
        DaylyAvarage.date = date;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static List<Double> getList() {
        return list;
    }

    public static void setList(List<Double> list) {
        DaylyAvarage.list = list;
    }

    public static List<Double> readFromFile() throws IOException {

        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        List<Double> list3 = new ArrayList<>();
        List<Double> list4 = new ArrayList<>();
        List<Double> list5 = new ArrayList<>();
        List<Double> list6 = new ArrayList<>();
        List<Double> list7 = new ArrayList<>();
        List<Double> finalList = new ArrayList<>();

        while(true) {
            String nextLine = bufferedReader.readLine();
            if(nextLine != null) {
                String[] tempArray = nextLine.split(";");
                if(checkDate(tempArray)) {
                    if (tempArray[2].equals("801") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list1.add(Double.parseDouble(tempArray[3]));
                    } else if (tempArray[2].equals("802") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list2.add(Double.parseDouble(tempArray[3]));
                    } else if (tempArray[2].equals("803") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list3.add(Double.parseDouble(tempArray[3]));
                    } else if (tempArray[2].equals("804") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list4.add(Double.parseDouble(tempArray[3]));
                    } else if (tempArray[2].equals("805") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list5.add(Double.parseDouble(tempArray[3]));
                    } else if (tempArray[2].equals("806") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list6.add(Double.parseDouble(tempArray[3]));
                    } else if (tempArray[2].equals("807") && !tempArray[3].equals("-999") &&
                            !tempArray[4].equals("F")) {
                        list7.add(Double.parseDouble(tempArray[3]));
                    }
                }
            } else {
                break;
            }
        }

        if(dataAvailability(list1)) {
            finalList.add(average(list1));
        } else {
            finalList.add(NaN);
        }
        if(dataAvailability(list2)) {
            finalList.add(average(list2));
        } else {
            finalList.add(NaN);
        }
        if(dataAvailability(list3)) {
            finalList.add(average(list3));
        } else {
            finalList.add(NaN);
        }
        if(dataAvailability(list4)) {
            finalList.add(average(list4));
        } else {
            finalList.add(NaN);
        }
        if(dataAvailability(list5)) {
            finalList.add(average(list5));
        } else {
            finalList.add(NaN);
        }
        if(dataAvailability(list6)) {
            finalList.add(average(list6));
        } else {
            finalList.add(NaN);
        }
        if(dataAvailability(list7)) {
            finalList.add(average(list7));
        } else {
            finalList.add(NaN);
        }

        return finalList;
    }
    
    public static void writeToFile(List<Double> list) {
        try {
            for(Double object : list) {
                bufferedWriter.append(object.toString() + ";");
            }
            bufferedWriter.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkDate(String[] tempArray) {
        String sub = tempArray[0].substring(0, 6);
        return sub.equals(dateCheck());
    }
    
    public static double average(List<Double> list) {
        int i = 0;
        Double j = 0.0;
        for(Double object : list) {
            j = j + object;
        }
        j = j / list.size();
        return j;
    }

    public static boolean dataAvailability(List<Double> list) {
        if(list.size() < 216) {
            return false;
        }
        return true;
    }

    public static String toLine() {
        return String.format("%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f", list.get(0), list.get(1), list.get(2),
                list.get(3), list.get(4), list.get(5), list.get(6));
    }

    public static void calculation() throws IOException {
        for(int i = 1; i < 32; i++) {
            setDate(i);
            fileReader = new FileReader(getFilePath());
            bufferedReader = new BufferedReader(fileReader);
            setList(readFromFile());
            bufferedReader.close();
            writeToFile(getList());
        }
    }

    public static String dateCheck() {
        if(getDate() < 10) {
            return "0" + getDate() + "0814";
        } else {
            return getDate() + "0814";
        }
    }
}
