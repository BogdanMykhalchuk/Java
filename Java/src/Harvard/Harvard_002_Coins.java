package Harvard;

import java.util.Scanner;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_002_Coins {
    public static void main(String[] args) {
        final int coin1 = 1;
        int coin1Quontity = 0;
        final int coin5 = 5;
        int coin5Quontity = 0;
        final int coin10 = 10;
        int coin10Quontity = 0;
        final int coin25 = 25;
        int coin25Quontity = 0;
        int change = 0;
        change = getInt();
        if(change >= coin25) {
            while(change >= coin25) {
                coin25Quontity++;
                change = change - coin25;
            }
        }
        if(change >= coin10) {
            while(change >= coin10) {
                coin10Quontity++;
                change = change - coin10;
            }
        }
        if(change >= coin5) {
            while(change >= coin5) {
                coin5Quontity++;
                change = change - coin5;
            }
        }
        if(change >= coin1) {
            while(change >= coin1) {
                coin1Quontity++;
                change = change - coin1;
            }
        }
        System.out.println("Выдайте покупателю:");
        if (coin25Quontity > 0) {
            System.out.println("Монеток номиналом 25 центов: " + coin25Quontity + ".");
        }
        if (coin10Quontity > 0) {
            System.out.println("Монеток номиналом 10 центов: " + coin10Quontity + ".");
        }
        if (coin5Quontity > 0) {
            System.out.println("Монеток номиналом 5 центов: " + coin5Quontity + ".");
        }
        if (coin1Quontity > 0) {
            System.out.println("Монеток номиналом 1 цент: " + coin1Quontity + ".");
        }
    }

    protected static int getInt() {
        int i = 0;
        boolean b = true;
        while (b) {
            Scanner digit = new Scanner(System.in);
            System.out.print("Введите количество сдачи (целое число): ");
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
