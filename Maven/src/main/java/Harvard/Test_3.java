package Harvard;

import java.util.regex.Pattern;

/**
 * Created by Bogdan on 25.01.2017.
 */
public class Test_3 {
    public static void main(String[] args) {
        String string = "Hume's ``Essays,'' vol. i., page 128: ``The Rise of Arts and";
        int i = Character.codePointAt(string, 16);
        if (Pattern.matches("[\\u0060]", string)) {
            System.out.println(i);
        }
        System.exit(0);
    }
}
