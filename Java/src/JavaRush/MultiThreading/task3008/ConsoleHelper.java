package JavaRush.MultiThreading.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dreawalker on 15.04.2017.
 */
public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string = "";
        try {
            string = bufferedReader.readLine();
        } catch(IOException e) {
            System.out.println("An error has been occurred. Please, try again.");
            string = readString();
        }
        return string;
    }

    public static int readInt() {
        int i = 0;
        try {
            i = Integer.parseInt(readString());
        } catch(NumberFormatException e) {
            System.out.println("An error has been occurred. Please, try again.");
            i = readInt();
        }
        return i;
    }
}
