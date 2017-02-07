package Harvard;

import java.util.Scanner;

import static java.lang.StrictMath.round;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_002_Coins_2 {
    public static void main(String[] args) {
        final int coin1 = 1;
        int coin1Quontity = 0;
        final int coin5 = 5;
        int coin5Quontity = 0;
        final int coin10 = 10;
        int coin10Quontity = 0;
        final int coin25 = 25;
        int coin25Quontity = 0;
        float allChange = 0;
        allChange = getFloat();
        System.out.println("allChange " + allChange);
        int wholePart = (int)allChange;
        System.out.println("wholePart " + wholePart);
        float fractionPart = allChange - wholePart;
        System.out.println("fractionPart " + fractionPart);
        float changeStart = fractionPart * 100;
        System.out.println("changeStart " + changeStart);
        int change = round(changeStart);
        System.out.println("change " + change);
        if(change >= coin25) {
            coin25Quontity = change / coin25;
            change = change - coin25 * coin25Quontity;
        }
        if(change >= coin10) {
            coin10Quontity = change / coin10;
            change = change - coin10 * coin10Quontity;
        }
        if(change >= coin5) {
            coin5Quontity = change / coin5;
            change = change - coin5 * coin5Quontity;
        }
        if(change >= coin1) {
            coin1Quontity = change / coin1;
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

    protected static float getFloat() {
        float i = 0;
        boolean b = true;
        while (b) {
            Scanner digit = new Scanner(System.in);
            System.out.println("Введите количество сдачи: ");
            if (digit.hasNextFloat()) {
                i = digit.nextFloat();
                b = false;
            } else {
                System.out.println("Вы ввели не число");
            }
        }
        return i;
    }
}
