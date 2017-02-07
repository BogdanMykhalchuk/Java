package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_005_EncriptionVigenere {
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
                "который хотите зашифровать: ");
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
                    int numberPositionMove = numberkeyedTextForEncription - 65;
                    numberTextForEncription = numberTextForEncription + numberPositionMove;
                    while (numberTextForEncription > 90) {
                        numberTextForEncription = numberTextForEncription - 26;
                    }
                    textForEncription.setCharAt(i, (char) numberTextForEncription);
                }
                if(Character.isLowerCase(textForEncription.charAt(i))) {
                    int numberTextForEncription = (int) textForEncription.charAt(i) + 32;
                    int numberkeyedTextForEncription = (int) keyedTextForEncription.charAt(i);
                    int numberPositionMove = numberkeyedTextForEncription - 97;
                    numberTextForEncription = numberTextForEncription + numberPositionMove;
                    while (numberTextForEncription > 122) {
                        numberTextForEncription = numberTextForEncription - 26;
                    }
                    textForEncription.setCharAt(i, (char) numberTextForEncription);
                }
            }
        }
        System.out.println(textForEncription);
    }

    public static String getString(String enter) {
        System.out.println(enter);
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        return text;
    }
    public static String checkArgsAlphabet(int x, String s) {
        String kTemp = null;
        if (x == 1 ) {
            for(int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    kTemp = s;
                } else {
                    System.out.println("Error 1");
                    System.exit(1);
                }
            }

        } else {
            System.out.println("Error 1");
            System.exit(1);
        }
        return kTemp;
    }
}
