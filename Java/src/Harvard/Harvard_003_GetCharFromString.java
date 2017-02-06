package Harvard;

import java.util.Scanner;

/**
 * Created by Dreawalker on 09.08.2016.
 */
public class Harvard_003_GetCharFromString {
    public static void main(String[] args){
        Scanner word = new Scanner(System.in);
        String wordS = word.nextLine();
        int n = wordS.length();
        for (int i = 0; i < n; i++) {
            System.out.printf("%c\n", wordS.charAt(i));
        }
    }
}
