package JavaRush.Collection.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        if(reader == null) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder textForEncription = new StringBuilder();
        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            textForEncription.append(readLine);
            readLine = bufferedReader.readLine();
            if(readLine != null) {
                textForEncription.append(System.getProperty("line.separator"));
            }
        }
        for(int i = 0; i < textForEncription.length(); i++) {
            if(Character.isLetter(textForEncription.charAt(i))) {
                if((Character.isUpperCase(textForEncription.charAt(i)))) {
                    int j = (int)textForEncription.charAt(i);
                    j = j + key;
                    while (j < 65) {
                        j = j + 26;
                    }
                    textForEncription.setCharAt(i, (char)j);
                }
                if((Character.isLowerCase(textForEncription.charAt(i)))){
                    int h = (int)textForEncription.charAt(i);
                    h = h + key;
                    while (h < 97) {
                        h = h + 26;
                    }
                    textForEncription.setCharAt(i, (char)h);
                }
            }
            if((Character.isDigit(textForEncription.charAt(i)))){
                int f = (int)textForEncription.charAt(i);
                f = f + key;
                while (f < 48) {
                    f = f + 10;
                }
                textForEncription.setCharAt(i, (char)f);
            }
        }
        return textForEncription.toString();
    }
}
