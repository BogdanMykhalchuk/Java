package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_004_EncriptionCesar {
    public static void main(String[] args) {
        String s = args[0];
        int count = args.length;
        int k = checkArgsInt(count, s);
        String getTextForEncription = getString("Пожалуйста, введите текст," +
                "который хотите зашифровать: ");
        StringBuilder textForEncription = new StringBuilder(getTextForEncription);
        for(int i = 0; i < textForEncription.length(); i++) {
            if(Character.isLetter(textForEncription.charAt(i))) {
                if((Character.isUpperCase(textForEncription.charAt(i)))) {
                    int j = (int)textForEncription.charAt(i);
                    j = j + k;
                    while (j > 90) {
                        j = j - 26;
                    }
                    textForEncription.setCharAt(i, (char)j);
                }
                if((Character.isLowerCase(textForEncription.charAt(i)))){
                    int h = (int)textForEncription.charAt(i);
                    h = h + k;
                    while (h > 122) {
                        h = h - 26;
                    }
                    textForEncription.setCharAt(i, (char)h);
                }
            }
            if((Character.isDigit(textForEncription.charAt(i)))){
                int f = (int)textForEncription.charAt(i);
                f = f + k;
                while (f > 57) {
                    f = f - 10;
                }
                textForEncription.setCharAt(i, (char)f);
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
    public static int checkArgsInt(int x, String s) {
        int kTemp = 0;
        if (x == 1) {
            try {
                kTemp = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Error 1");
                System.exit(1);
            }
        } else {
            System.out.println("Error 1");
            System.exit(1);
        }
        return kTemp;
    }
}
