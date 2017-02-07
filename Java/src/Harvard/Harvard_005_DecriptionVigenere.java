package Harvard;

import static Harvard.Harvard_004_EncriptionCesar.getString;
import static Harvard.Harvard_005_EncriptionVigenere.checkArgsAlphabet;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_005_DecriptionVigenere {
    public static void main(String[] args) {
        String s = args[0];
        int j = 0;
        int count = args.length;
        String key = checkArgsAlphabet(count, s);
        System.out.println(key);
        String k = key.toUpperCase();
        System.out.println(k);
        int lengthK = k.length();
        String getTextForEncription = getString("Пожалуйста, введите текст," +
                "который хотите расшифровать: ");
        StringBuilder textForEncription = new StringBuilder(getTextForEncription);
        StringBuilder keyedTextForEncription = new StringBuilder(getTextForEncription);
        System.out.println(keyedTextForEncription);
        for(int i = 0; i < textForEncription.length(); i++) {
            if(Character.isLetter(textForEncription.charAt(i))) {
                keyedTextForEncription.setCharAt(i, k.charAt(j++ % lengthK));
            }
        }
        System.out.println(keyedTextForEncription);
        for(int i = 0; i < textForEncription.length(); i++) {
            if(Character.isLetter(textForEncription.charAt(i))) {
                if(Character.isUpperCase(textForEncription.charAt(i))) {
                    int numberTextForEncription = (int) textForEncription.charAt(i);
                    int numberkeyedTextForEncription = (int) keyedTextForEncription.charAt(i);
                    int numberPositionMove = numberkeyedTextForEncription + 65;
                    numberTextForEncription = numberTextForEncription - numberPositionMove;
                    while (numberTextForEncription < 65) {
                        numberTextForEncription = numberTextForEncription + 26;
                    }
                    textForEncription.setCharAt(i, (char) numberTextForEncription);
                }
                if(Character.isLowerCase(textForEncription.charAt(i))) {
                    int numberTextForEncription = (int) textForEncription.charAt(i) + 32;
                    int numberkeyedTextForEncription = (int) keyedTextForEncription.charAt(i);
                    int numberPositionMove = numberkeyedTextForEncription + 97;
                    numberTextForEncription = numberTextForEncription - numberPositionMove;
                    while (numberTextForEncription < 97) {
                        numberTextForEncription = numberTextForEncription + 26;
                    }
                    textForEncription.setCharAt(i, (char) numberTextForEncription);
                }
            }
        }
        System.out.println(textForEncription);
    }
}
