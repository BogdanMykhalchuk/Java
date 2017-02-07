package Harvard;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Created by Bogdan on 20.01.2017.
 */
public class SpellChecker {

    private static Writer out;

    private static File file = new File("C:\\Users\\Bogdan\\Desktop\\Java\\pset5\\checked.txt");

    static void spellCheck(String filePath) {

        GregorianCalendar startLoadDictionary = new GregorianCalendar();
        HashSet<String> dictionarySet = dictionaryLoad("C:\\Users\\Bogdan\\Desktop\\Java\\pset5\\dictionaries\\large");
        GregorianCalendar finishLoadDictionary = new GregorianCalendar();

        GregorianCalendar startLoadText = new GregorianCalendar();
        ArrayList<String> checkArray = textLoad(filePath);
        GregorianCalendar finishLoadText = new GregorianCalendar();

        GregorianCalendar startCheckText = new GregorianCalendar();
        ArrayList<String> misspelledWords = compareTextToDictionary(dictionarySet, checkArray);
        GregorianCalendar finishCheckText = new GregorianCalendar();

        GregorianCalendar startSizing = new GregorianCalendar();
        int wordsMisspelled = misspelledWords.size();
        int wordsDictionary = dictionarySet.size();
        int wordsText = checkArray.size();
        GregorianCalendar finishSizing = new GregorianCalendar();

        GregorianCalendar startWriting = new GregorianCalendar();
        writeToFile(misspelledWords);
        GregorianCalendar finishWriting = new GregorianCalendar();

        long timeInLoadDictionary = finishLoadDictionary.getTimeInMillis() - startLoadDictionary.getTimeInMillis();
        long timeInLoadText = finishLoadText.getTimeInMillis() - startLoadText.getTimeInMillis();
        long timeInCheck = finishCheckText.getTimeInMillis() - startCheckText.getTimeInMillis();
        long timeInSize = finishSizing.getTimeInMillis() - startSizing.getTimeInMillis();
        long timeTowriteToFile = finishWriting.getTimeInMillis() - startWriting.getTimeInMillis();

        try {
            out.append("Виявлено помилок = ").append(String.valueOf(wordsMisspelled)).append("\n");
            out.append("Всього слів у словнику = ").append(String.valueOf(wordsDictionary)).append("\n");
            out.append("Всього слів у тексті = ").append(String.valueOf(wordsText)).append("\n");
            out.append("Час завантаження словника = ").append(String.valueOf(timeInLoadDictionary)).append("\n");
            out.append("Час завантаження тексту = ").append(String.valueOf(timeInLoadText)).append("\n");
            out.append("Час преревірки = ").append(String.valueOf(timeInCheck)).append("\n");
            out.append("Час визначення розміру = ").append(String.valueOf(timeInSize)).append("\n");
            out.append("Час запису помилкових слів у файл = ").append(String.valueOf(timeTowriteToFile)).append("\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private static HashSet<String> dictionaryLoad(String path) {
        BufferedReader bufferedReader;
        HashSet<String> hashSet = new HashSet<String>();
        String string;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            string = bufferedReader.readLine();
            while(string != null) {
                hashSet.add(string);
                string = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashSet;
    }

    private static ArrayList<String> textLoad(String path) {
        BufferedReader bufferedReader;
        ArrayList<String> checkArray;
        ArrayList<String> checkedArray = new ArrayList<String>();
        String line;
        String[] arrayString;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            line = bufferedReader.readLine();
            while(line != null) {
                arrayString = line.split("!\"'");
                line = arrayToString(arrayString);
                arrayString = line.split(",\"'");
                line = arrayToString(arrayString);
                arrayString = line.split("\\,''");
                line = arrayToString(arrayString);
                arrayString = line.split("\\,'");
                line = arrayToString(arrayString);
                arrayString = line.split("\\!'");
                line = arrayToString(arrayString);
                arrayString = line.split("\\?'");
                line = arrayToString(arrayString);
                arrayString = line.split("\\?\"'");
                line = arrayToString(arrayString);
                arrayString = line.split("!");
                line = arrayToString(arrayString);
                arrayString = line.split("\\?");
                line = arrayToString(arrayString);
                arrayString = line.split("\"");
                line = arrayToString(arrayString);
                arrayString = line.split(",");
                line = arrayToString(arrayString);
                arrayString = line.split(":");
                line = arrayToString(arrayString);
                arrayString = line.split("]");
                line = arrayToString(arrayString);
                arrayString = line.split("\\[");
                line = arrayToString(arrayString);
                arrayString = line.split(";");
                line = arrayToString(arrayString);
                arrayString = line.split("\\*");
                line = arrayToString(arrayString);
                arrayString = line.split(" ");
                checkArray = arrayFix(arrayString);
                for(String string : checkArray) {
                    if(string != null) {
                        checkedArray.add(string);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkedArray;
    }

    private static String arrayToString(String[] array) {
        String newString = "";
        for(String string : array) {
            newString = newString + string;
        }
        return newString;
    }

    private static ArrayList<String> arrayFix(String[] array) {
        ArrayList<String> checkArray = new ArrayList<String>();
        char[] chars;
        String[] tempArray;
        for(String string : array) {
            if(!string.equals(" ") && !string.equals("")) {
                tempArray = checkString(string);
                for (String tempString : tempArray) {
                    tempArray = checkString(tempString);
                    for (String tempString1 : tempArray) {
                        tempArray = checkString(tempString1);
                        for (String tempString2 : tempArray) {
                            tempArray = checkString(tempString2);
                            for (String tempString3 : tempArray) {
                                chars = tempString3.toCharArray();
                                if (checkStringForDigits(chars) && tempString3.contains("\'")) {
                                    if(checkStringForNumbersAndApostrophe(tempString3)) {
                                        tempArray = tempString3.split("\'");
                                    }
                                } else {
                                    tempArray = checkString(tempString3);
                                }
                                for (String tempString4 : tempArray) {
                                    if (!tempString4.equals("") && !tempString4.equals("\'") && !tempString4.equals("#")
                                            && !tempString4.equals("%") && !tempString4.equals("?") &&
                                            ifStringIsANCII(tempString4)) {
                                        chars = tempString4.toCharArray();
                                        if (!checkStringForDigits(chars)) {
                                            checkArray.add(tempString4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return checkArray;
    }

    private static boolean ifStringIsANCII(String string) {
        boolean b = false;
        if(string.matches("\\w+") || string.contains("\'")) {
            b = true;
        }
        return b;
    }

    private static boolean checkStringForNumbersAndApostrophe(String string) {
        String[] stringArray;
        char[] chars = string.toCharArray();
        int i;
        for(i = 0; i < chars.length; i++) {
            if(Character.valueOf(chars[i]).equals('\'')) {
                break;
            }
        }
        String tempString = string.substring(0, i);
        boolean b = true;
        chars = tempString.toCharArray();
        for(char ch : chars) {
            if(!Character.isDigit(ch)) {
                b = false;
                break;
            }
        }
        return b;
    }

    private static String[] checkString(String string) {
        String[] tempArray;
        if (string.contains("-")) {
            tempArray = string.split("-");
            return tempArray;
        }

        else if (string.contains("_")) {
            tempArray = string.split("_");
            return tempArray;
        }

        else if (Pattern.matches(".*[^\\x00-\\x7F].*", string)) {
            ArrayList<String> stringList = new ArrayList<String>();
            tempArray = stringListArrayToArray(splitStringForCirillic(string, stringList));
            return tempArray;
        }

        else if (string.contains("/")) {
            tempArray = string.split("/");
            return tempArray;
        }

        else if (string.contains("@")) {
            tempArray = string.split("@");
            return tempArray;
        }

        else if (string.contains("(")) {
            tempArray = string.split("\\(");
            return tempArray;
        }

        else if (string.contains(")")) {
            tempArray = string.split("\\)");
            return tempArray;
        }

        else if (string.contains("?")) {
            tempArray = string.split("\\?");
            return tempArray;
        }

        else if (string.contains("&")) {
            tempArray = string.split("&");
            return tempArray;
        }

        else if (string.contains(".")) {
            tempArray = string.split("\\.");
            return tempArray;
        }

        else if (string.startsWith(" ") && string.length() > 1) {
            string = string.substring(1);
            tempArray = new String[]{string};
            return tempArray;
        }

        else if (string.startsWith("'") || string.startsWith("`")) {
            if (string.length() > 1) {
                string = string.substring(1);
                tempArray = new String[]{string};
                return tempArray;
            } else {
                tempArray = new String[]{string};
                return tempArray;
            }

        } else {
            tempArray = new String[]{string};
            return tempArray;
        }
    }

    private static boolean checkStringForDigits(char[] stringToChar) {
        boolean b = false;
        for(char ch : stringToChar) {
            if(Character.isDigit(ch)) {
                b = true;
            }
        }
        return b;
    }

    private static ArrayList<String> compareTextToDictionary(HashSet<String> dictionarySet, ArrayList<String> checkArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String stringTemp;
        for(String string : checkArray) {
            stringTemp = string.toLowerCase();
            if(!dictionarySet.contains(stringTemp)) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    private static void writeToFile(ArrayList<String> misspelledWords) {
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "Cp1251"));
            out.append("\n");
            out.append("MISSPELLED WORDS" + "\n");
            out.append("\n");
            for(String string : misspelledWords) {
                out.append(string).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> splitStringForCirillic(String string, ArrayList<String> stringList) {
        int count = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Pattern.matches(".*[^\\x00-\\x7F].*", String.valueOf(chars[i]))) {
                string = "";
                for (int j = count; j < i; j++) {
                    string = string + chars[j];
                }
                count = i + 1;
                stringList.add(string);
            }
        }
        string = "";
        for(int i = count; i < chars.length; i++) {
            string = string + chars[i];
        }
        stringList.add(string);
        return stringList;
    }

    private static String[] stringListArrayToArray(ArrayList<String> list) {
        Object[] objectArray = list.toArray();
        String[] stringArray = new String[objectArray.length];
        for(int i = 0; i < objectArray.length; i++) {
            stringArray[i] = objectArray[i].toString();
        }
        return stringArray;
    }
}