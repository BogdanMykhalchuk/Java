package UFIREG;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;
import static java.lang.Double.NaN;

/**
 * Created by Bogdan on 18.10.2016.
 */
public class DailyAverageWindows {

    private static int dayOfMonth;
    private static String datePattern;
    /** pattern of the name of the file: "UFIREG_Myy.txt" (Locale.US)) M - month, yy - year;*/
    private static String inputFilePath;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    static void startCalculations(String args) {
        inputFilePath = args;
        fileNameValidation();
        setDatePattern(inputFilePath);
        try {
            String firstPartOfOutputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf('\\') + 1);
            String secondPartOfOutputFilePath = inputFilePath.substring(inputFilePath.lastIndexOf('\\'),
                    inputFilePath.length() - 4);
            String outputFilePath = firstPartOfOutputFilePath + secondPartOfOutputFilePath + "_Daily.csv";
            FileWriter fileWriter = new FileWriter(outputFilePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            calculation();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TheJobIsDone.printCongratulation();
    }

    private static int getDayOfMonth() {
        return dayOfMonth;
    }

    private static void setDayOfMonth(int dayOfMonth) {
        DailyAverageWindows.dayOfMonth = dayOfMonth;
    }

    private static void setDatePattern(String inputFilePath) {
        int i = inputFilePath.lastIndexOf('_');
        datePattern = inputFilePath.substring(i + 1, i + 5);
    }

    private static void calculation() throws IOException {
        for(int i = 1; i < 32; i++) {
            setDayOfMonth(i);
            FileReader fileReader = new FileReader(inputFilePath);
            bufferedReader = new BufferedReader(fileReader);
            writeToFile(readFromFile());
            bufferedReader.close();
        }
    }

    private static void fileNameValidation() {
        int i = inputFilePath.lastIndexOf('\\');

        if(!inputFilePath.substring(i + 1, i + 8).equals("UFIREG_")) {
            throw new IllegalArgumentException("Wrong File");
        }

        boolean b = true;
        String sub = inputFilePath.substring(i + 8, i + 12);

        for(int j = 0; j < sub.length(); j++) {
            if(!isDigit(sub.charAt(j))) {
                b = false;
            }
        }

        if(!b) {
            throw new IllegalArgumentException("Wrong File");
        }

        if(!inputFilePath.substring(i + 12, i + 16).equals(".txt")) {
            throw new IllegalArgumentException("Wrong File");
        }
    }

    private static boolean checkDate(String[] tempArray) {
        String sub1 = tempArray[0].substring(0, 6);
        String sub2;
        if(getDayOfMonth() < 10) {
            sub2 = "0" + getDayOfMonth() + datePattern;
        } else {
            sub2 = getDayOfMonth() + datePattern;
        }
        return sub1.equals(sub2);
    }

    private static List<Double> readFromFile() throws IOException {

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
                    if(!tempArray[3].equals("-999") && !tempArray[4].equals("F")) {
                        switch (tempArray[2]) {
                            case "801":
                                list1.add(Double.parseDouble(tempArray[3]));
                                break;
                            case "802":
                                list2.add(Double.parseDouble(tempArray[3]));
                                break;
                            case "803":
                                list3.add(Double.parseDouble(tempArray[3]));
                                break;
                            case "804":
                                list4.add(Double.parseDouble(tempArray[3]));
                                break;
                            case "805":
                                list5.add(Double.parseDouble(tempArray[3]));
                                break;
                            case "806":
                                list6.add(Double.parseDouble(tempArray[3]));
                                break;
                            case "807":
                                list7.add(Double.parseDouble(tempArray[3]));
                                break;
                        }
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

    private static boolean dataAvailability(List<Double> list) {
        return list.size() >= 216;
    }

    private static double average(List<Double> list) {
        Double j = 0.0;
        for(Double object : list) {
            j = j + object;
        }
        j = j / list.size();
        return j;
    }

    private static void writeToFile(List<Double> list) {
        try {
            for(Double object : list) {
                bufferedWriter.append(object.toString()).append(";");
            }
            bufferedWriter.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
