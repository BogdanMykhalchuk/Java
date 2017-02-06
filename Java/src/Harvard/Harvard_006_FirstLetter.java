package Harvard;

import Test.GetString;

/**
 * Created by Dreawalker on 12.08.2016.
 */
public class Harvard_006_FirstLetter {
    public static void main(String[] args) {
        String name1 = GetString.getString("Введите имя: ");
        String name = name1.toUpperCase();
        System.out.println(name);
        int indexWhiteSpace1 = name.indexOf(' ');
        System.out.println(indexWhiteSpace1);
        int indexWhiteSpace2 = 0;
        int indexWhiteSpace3 = 0;
        int indexWhiteSpace4 = 0;
        int indexWhiteSpace5 = 0;

        if (indexWhiteSpace1 > 0) {
            indexWhiteSpace2 = name.indexOf(' ', indexWhiteSpace1 + 1);
            System.out.println(indexWhiteSpace2);
        }
        if (indexWhiteSpace2 > 0) {
            indexWhiteSpace3 = name.indexOf(' ', indexWhiteSpace2 + 1);
            System.out.println(indexWhiteSpace3);
        }
        if (indexWhiteSpace3 > 0) {
            indexWhiteSpace4 = name.indexOf(' ', indexWhiteSpace3 + 1);
            System.out.println(indexWhiteSpace4);
        }
        if(indexWhiteSpace4 > 0) {
            indexWhiteSpace5 = name.indexOf(' ', indexWhiteSpace4 + 1);
            System.out.println(indexWhiteSpace5);
        }

        if (indexWhiteSpace5 > 0) {
            System.out.printf("%c%c%c%c%c%c", name.charAt(0), name.charAt(1 + indexWhiteSpace1),
                    name.charAt(1 + indexWhiteSpace2), name.charAt(1 + indexWhiteSpace3),
                    name.charAt(1 + indexWhiteSpace4), name.charAt(1 + indexWhiteSpace5));
        }
        else if (indexWhiteSpace4 > 0) {
            System.out.printf("%c%c%c%c%c", name.charAt(0), name.charAt(1 + indexWhiteSpace1),
                    name.charAt(1 + indexWhiteSpace2), name.charAt(1 + indexWhiteSpace3),
                    name.charAt(1 + indexWhiteSpace4));
        }
        else if (indexWhiteSpace3 > 0) {
            System.out.printf("%c%c%c%c", name.charAt(0), name.charAt(1 + indexWhiteSpace1),
                    name.charAt(1 + indexWhiteSpace2), name.charAt(1 + indexWhiteSpace3));
        }
        else if (indexWhiteSpace2 > 0) {
            System.out.printf("%c%c%c", name.charAt(0), name.charAt(1 + indexWhiteSpace1),
                    name.charAt(1 + indexWhiteSpace2));
        }
        else if (indexWhiteSpace1 > 0) {
            System.out.printf("%c%c", name.charAt(0), name.charAt(1 + indexWhiteSpace1));
        }
        else {
            System.out.printf("%c", name.charAt(0));
        }
    }
}
