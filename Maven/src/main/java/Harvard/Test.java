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
        String string = "Laocoцn";
        ArrayList<String> stringList = new ArrayList<String>();
        if (Pattern.matches(".*[^\\x00-\\x7F].*", string)) {
            array = stringListArrayToArray(splitStringForCirillic(string, stringList));
            System.out.println(Arrays.toString(array));
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
