package Harvard;

import Test.GetString;

/**
 * Created by Dreawalker on 14.08.2016.
 */
public class Harvard_006_FirstLetter2 {
    public static void main(String[] args) {
        String name = GetString.getString("Введите имя: ");
        name.toUpperCase();
        int indexWhiteSpace1 = name.indexOf(' ');
        int indexWhiteSpace2 = name.indexOf(' ', indexWhiteSpace1 + 1);
        int indexWhiteSpace3 = name.indexOf(' ', indexWhiteSpace2 + 1);
        int indexWhiteSpace4 = name.indexOf(' ', indexWhiteSpace3 + 1);
        int indexWhiteSpace5 = name.indexOf(' ', indexWhiteSpace4 + 1);
        System.out.println(indexWhiteSpace2);
        //for (int i = 0; )
    }
}
