package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dreawalker on 14.03.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException
    {
        double countSpaces = 0;
        double countChars = 0;
        BufferedReader br = new BufferedReader(new FileReader("D:/Test.txt"));
        String string = br.readLine();
        while(string != null) {
            String[] array = string.split(" ");
            countSpaces = countSpaces + array.length - 1;
            countChars = countChars + string.length();
            string = br.readLine();
        }
        double ratio = countSpaces / countChars * 100;
        System.out.println("Spaces: " + countSpaces);
        System.out.println("Chars: " + countChars);
        System.out.println(String.format("Ratio: %.2f", ratio));
        br.close();
    }
}
