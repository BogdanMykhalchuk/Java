package Test;

import java.util.Scanner;

/**
 * Created by Dreawalker on 11.08.2016.
 */
public class GetPositiveInt {
    public static int getPositiveInt(String x) {
        int i = 0;
        boolean b = true;
        while (b) {
            System.out.println(x);
            Scanner number = new Scanner(System.in);
            if(number.hasNextInt()) {
                i = number.nextInt();
                if(i > 0) {
                    System.out.println("Спасибо.");
                    b = false;
                } else {
                    System.out.println("Вы ввели орицательное число или 0");
                }
            } else {
                System.out.println("Ошибка ввода");
            }
        }
        return i;
    }
}
