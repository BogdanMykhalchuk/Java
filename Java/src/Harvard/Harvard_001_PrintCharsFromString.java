package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_001_PrintCharsFromString {
    public static void main(String[] args) {
        Scanner word = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String wordChar = word.nextLine();
        for(int i = 0; i < wordChar.length(); i++) {
            System.out.println(wordChar.charAt(i));
        }
    }
}
