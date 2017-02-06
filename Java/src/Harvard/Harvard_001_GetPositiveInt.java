package Harvard;

import java.util.Scanner;

/**
 * Created by Dreawalker on 09.08.2016.
 */
public class Harvard_001_GetPositiveInt {
    public static void main(String[] args) {
        int i = 0;
        boolean b = true;
        while (b) {
            System.out.println("Введите положительное целое число: ");
            Scanner number = new Scanner(System.in);
            if(number.hasNextInt()) {
                i = number.nextInt();
                if(i > 0) {
                    System.out.println("Спасибо. Ваше число: " + i);
                    b = false;
                } else {
                    System.out.println("Вы ввели орицательное число или 0");
                }
            } else {
                System.out.println("Ошибка ввода");
            }
        }
    }
}
