package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_001_Switch {
    public static void main(String[] args) {
        int i = 0;
        boolean b = true;
        while (b) {
            Scanner digit = new Scanner(System.in);
            System.out.println("Введите целое число: ");
            if (digit.hasNextInt()) {
                i = digit.nextInt();
                b = false;
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }

        switch (i) {
            case 30:
                System.out.println("That is OK");
                break;
            case 50:
                System.out.println("That is NO good");
                break;
            default:
                System.out.println("I dont know");
                break;
        }

    }
}
