package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_001_GetInt {
    public static void main(String[] args) {
        getInt1();
    }
    protected static void getInt1() {
        int i;
        boolean b = true;
        while  (b) {
            Scanner digit = new Scanner(System.in);
            System.out.print("Введите целое число: ");
            if (digit.hasNextInt()) {
                i = digit.nextInt();
                System.out.print("Ваше целое число: " + i);
                b = false;
            } else {
                System.out.print("Вы ввели не целое число");
            }
        }
    }
}
