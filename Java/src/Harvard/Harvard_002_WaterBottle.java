package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_002_WaterBottle {
    public static void main(String[] args) {
        int c = 6;
        int bottles = getInt() * c;
        System.out.println("Вы использовали " + bottles + " пол-литровых бутылочек воды.");
    }
    protected static int getInt() {
        int i = 0;
        boolean b = true;
        while (b) {
            Scanner digit = new Scanner(System.in);
            System.out.print("Введите количество минут проведенное в душе (целое число): ");
            if (digit.hasNextInt()) {
                i = digit.nextInt();
                b = false;
            } else {
                System.out.print("Вы ввели не целое число");
            }
        }
        return i;
    }
}
