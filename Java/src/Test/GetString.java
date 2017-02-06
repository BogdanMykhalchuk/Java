package Test;

import java.util.Scanner;

/**
 * Created by Dreawalker on 06.02.2017.
 */
public class GetString {
    public static void main(String[] args) {
        String string = getString("Введите имя:");
        System.out.println(string);
    }
    public static String getString(String string) {
        System.out.println(string);
        Scanner scanner = new Scanner(System.in);
        String readLine = scanner.nextLine();
        return readLine;
    }
}
