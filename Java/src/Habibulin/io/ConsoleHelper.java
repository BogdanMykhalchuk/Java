package Habibulin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dreawalker on 24.04.2017.
 */
public class ConsoleHelper {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static void writeMessage(String message) {
        System.out.println(message);
    }

    static String readString() {
        String string = "";
        try {
            string = bufferedReader.readLine();
        } catch(IOException e) {
            System.out.println("An error has been occurred. Please, try again.");
            string = readString();
        }
        return string;
    }

    static int readInt() {
        int i = 0;
        try {
            i = Integer.parseInt(bufferedReader.readLine());
        } catch(IOException e) {
            System.out.println("An error has been occurred. Please, try again.");
            i = readInt();
        }
        return i;
    }
}
