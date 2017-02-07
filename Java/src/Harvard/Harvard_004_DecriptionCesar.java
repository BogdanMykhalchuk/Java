package Harvard;

import static Harvard.Harvard_004_EncriptionCesar.checkArgsInt;
import static Harvard.Harvard_004_EncriptionCesar.getString;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_004_DecriptionCesar {
    public static void main(String[] args) {
        String s = args[0];
        int count = args.length;
        int k = checkArgsInt(count, s);
        String getTextForEncription = getString("Пожалуйста, введите текст," +
                "который хотите расшифровать: ");
        StringBuilder textForEncription = new StringBuilder(getTextForEncription);
        for(int i = 0; i < textForEncription.length(); i++) {
            if(Character.isLetter(textForEncription.charAt(i))) {
                if((Character.isUpperCase(textForEncription.charAt(i)))) {
                    int j = (int)textForEncription.charAt(i);
                    j = j - k;
                    while (j < 65) {
                        j = j + 26;
                    }
                    textForEncription.setCharAt(i, (char)j);
                }
                if((Character.isLowerCase(textForEncription.charAt(i)))){
                    int h = (int)textForEncription.charAt(i);
                    h = h - k;
                    while (h < 97) {
                        h = h + 26;
                    }
                    textForEncription.setCharAt(i, (char)h);
                }
            }
            if((Character.isDigit(textForEncription.charAt(i)))){
                int f = (int)textForEncription.charAt(i);
                f = f - k;
                while (f < 48) {
                    f = f + 10;
                }
                textForEncription.setCharAt(i, (char)f);
            }
        }
        System.out.println(textForEncription);
    }
}
