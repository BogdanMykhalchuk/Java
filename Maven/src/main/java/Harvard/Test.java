package Harvard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Bogdan on 19.01.2017.
 */
public class Test {
    public static void main(String[] args) {
        String[] array;
        String string = "dghДfjГЖfklБkgl";
        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<String> stringList = new ArrayList<String>();
        for(int i = 0x0410; i < 0x0450; i++) {
            list.add((char)i);
        }
        if (Pattern.matches(".*\\p{InCyrillic}.*", string)) {
            array = stringListArrayToArray(splitStringForCyrillic(string, list, stringList));
            System.out.println(Arrays.toString(array));
        }
    }

    private static ArrayList<String> splitStringForCyrillic(String string, ArrayList<Character> list, ArrayList<String> stringList) {
        char[] chars;
        int count = 0;
        chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])) {
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

    private static String arrayToString(String[] array) {
        String newString = "";
        for(String string : array) {
            newString = newString + string;
        }
        return newString;
    }

    private static String[] stringListArrayToArray(ArrayList<String> list) {
        Object[] objectArray = list.toArray();
        String[] stringArray = new String[objectArray.length];
        for(int i = 0; i < objectArray.length; i++) {
            stringArray[i] = objectArray[i].toString();
        }
        return stringArray;
    }

//    private static ArrayList<String> splitStringForCirillic(String string, ArrayList<Character> list, ArrayList<String> stringList) {
//        String[] stringArray;
//        String[] tempArray;
//        if (Pattern.matches(".*\\p{InCyrillic}.*", string)) {
//            for (Character ch : list) {
//                if (string.contains(ch.toString())) {
//                    stringArray = string.split(ch.toString());
//                    for(String newString : stringArray) {
//                        if (Pattern.matches(".*\\p{InCyrillic}.*", newString)) {
//                            tempArray = splitStringForCirillic(newString, list);
//                            for(String newString1 : tempArray) {
//                                stringList.add(newString1);
//                            }
//                        }
//                        stringList.add(newString);
//                    }
//                }
//            }
//        }
//        return stringList;
//    }
//
//    private static String[] splitStringForCirillic(String string, ArrayList<Character> list) {
//        String[] stringArray = null;
//        if (Pattern.matches(".*\\p{InCyrillic}.*", string)) {
//            for (Character ch : list) {
//                if (string.contains(ch.toString())) {
//                    stringArray = string.split(ch.toString());
//                    for(String newString : stringArray) {
//                        if (Pattern.matches(".*\\p{InCyrillic}.*", newString)) {
//                            stringArray = splitStringForCirillic(newString, list);
//                        }
//                    }
//                }
//            }
//        }
//        return stringArray;
//    }
}
