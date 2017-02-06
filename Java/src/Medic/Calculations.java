package Medic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;

/**
 * Created by Kvitochka on 22.10.2016.
 */
class Calculations {

    private static String inputFilePath;
    private static BufferedWriter bufferedWriter;
    private static BufferedWriter bufferedWriter2;
    private static int  fileNameBeginning;
    private static double average;
    private static double skv;

    static void startCalculations(String args) {
        inputFilePath = args;
        fileNameBeginning = inputFilePath.lastIndexOf('\\');
        fileNameValidation();
        try {
            String firstPartOfOutputFilePath = inputFilePath.substring(0, fileNameBeginning + 1);
            String secondPartOfOutputFilePath = "MedicalDataCalculated.csv";
            String outputFilePath = firstPartOfOutputFilePath + secondPartOfOutputFilePath;
            FileWriter fileWriter = new FileWriter(outputFilePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            secondPartOfOutputFilePath = "MedicalDataCalculated2.csv";
            outputFilePath = firstPartOfOutputFilePath + secondPartOfOutputFilePath;
            FileWriter fileWriter2 = new FileWriter(outputFilePath);
            bufferedWriter2 = new BufferedWriter(fileWriter2);
            calculation();
            bufferedWriter.close();
            bufferedWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TheJobIsDone.printCongratulation();
    }


    private static void calculation() throws IOException {
        FileReader fileReader = new FileReader(inputFilePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while(true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                writeToFile(readFromFile(line));
                writeToFile2(readFromFile2());
            } else {
                break;
            }
        }
        bufferedReader.close();
    }

    private static void fileNameValidation() {
        if(!inputFilePath.substring(fileNameBeginning + 1).equals("MedicData.csv")) {
            throw new IllegalArgumentException("Wrong File");
        }
    }

    private static List<Double> readFromFile(String line) throws IOException {
        List<Double> list = new ArrayList<>();
        String[] tempArray = line.split(";");
        average = average(tempArray);
        skv = skv(tempArray);
        double halfOfSkv = skv / 2;
        for (String string : tempArray) {
            try {
                double j = Double.parseDouble(string);
                if (j < average - 3 * skv) {
                    list.add(0.01);
                } else if (j >= average - 3 * skv && j < average - 2.5 * skv) {
                    list.add(0.04);
                } else if (j >= average - 2.5 * skv && j < average - 2 * skv) {
                    list.add(0.09);
                } else if (j >= average - 2 * skv && j < average - 1.5 * skv) {
                    list.add(0.2);
                } else if (j >= average - 1.5 * skv && j < average - skv) {
                    list.add(0.32);
                } else if (j >= average - skv && j < average - 0.5 * skv) {
                    list.add(0.41);
                } else if (j >= average - 0.5 * skv && j < average) {
                    list.add(0.46);
                } else if (j >= average && j < average + 0.5 * skv) {
                    list.add(0.54);
                } else if (j >= average + 0.5 * skv && j < average + skv) {
                    list.add(0.59);
                } else if (j >= average + skv && j < average + 1.5 * skv) {
                    list.add(0.68);
                } else if (j >= average + 1.5 * skv && j < average + 2.0 * skv) {
                    list.add(0.8);
                } else if (j >= average + 2 * skv && j < average + 2.5 * skv) {
                    list.add(0.91);
                } else if (j >= average + 2.5 * skv && j < average + 3 * skv) {
                    list.add(0.96);
                } else if (j >= average + 3 * skv) {
                    list.add(0.99);
                }

            } catch (NumberFormatException e) {
                list.add(NaN);
            }
        }
        list.add(average);
        list.add(skv);
        list.add(halfOfSkv);
        return list;
    }

    private static List<String> readFromFile2() throws IOException {
        List<String> list = new ArrayList<>();
        list.add(String.format("менше %.2f", average - 3 * skv));
        list.add(String.format("%.2f - %.2f", average - 3 * skv, average - 2.5 * skv));
        list.add(String.format("%.2f - %.2f", average - 2.5 * skv, average - 2 * skv));
        list.add(String.format("%.2f - %.2f", average - 2 * skv, average - 1.5 * skv));
        list.add(String.format("%.2f - %.2f", average - 1.5 * skv, average - skv));
        list.add(String.format("%.2f - %.2f", average - skv, average - 0.5 * skv));
        list.add(String.format("%.2f - %.2f", average - 0.5 * skv, average));
        list.add(String.format("%.2f - %.2f", average, average + 0.5 * skv));
        list.add(String.format("%.2f - %.2f", average + 0.5 * skv, average + skv));
        list.add(String.format("%.2f - %.2f", average + skv, average + 1.5 * skv));
        list.add(String.format("%.2f - %.2f", average + 1.5 * skv, average + 2.0 * skv));
        list.add(String.format("%.2f - %.2f", average + 2 * skv, average + 2.5 * skv));
        list.add(String.format("%.2f - %.2f", average + 2.5 * skv, average + 3 * skv));
        list.add(String.format("%.2f i більше", average + 3 * skv));

        return list;
    }

    private static double average(String[] array) {
        int i = 0;
        Double j = 0.0;
        for (String anArray : array) {
            try {
                Double z = Double.parseDouble(anArray);
                j = j + z;
            } catch (NumberFormatException e) {
            i++;
            }
        }
        j = j / (array.length - i);
        return j;
    }

    private static double skv(String[] array) {
        int i = 1;
        Double j = 0.0;
        for (String anArray : array) {
            try {
                Double z = Double.parseDouble(anArray);
                j = j + doubleNumber(z - average);
            } catch (NumberFormatException e) {
                i++;
            }
        }
        j = j / (array.length - i);
        j = Math.sqrt(j);
        return j;
    }

    private static double doubleNumber(double i) {
        return i * i;
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

    private static void writeToFile2(List<String> list) {
        try {
            for(String object : list) {
                bufferedWriter2.append(object.toString()).append(";");
            }
            bufferedWriter2.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

