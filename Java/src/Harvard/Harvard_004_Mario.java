package Harvard;

import java.util.Scanner;

/**
 * Created by Dreawalker on 10.08.2016.
 */
public class Harvard_004_Mario {
    public static void main(String[] args) {
        print();
    }
    private static int getNumber() {
        int i = 0;
        boolean b = true;
        while (b) {
            System.out.println("Введите положительное целое число от 1 до 23: ");
            Scanner number = new Scanner(System.in);
            if(number.hasNextInt()) {
                i = number.nextInt();
                if(i >= 0 && i <= 23) {
                    System.out.println("Спасибо. Ваше число: " + i);
                    b = false;
                } else {
                    System.out.println("Вы ввели орицательное число");
                }
            } else {
                System.out.println("Ошибка ввода");
            }
        }
        return i;
    }
    private static void print() {
        int quantity = getNumber();
        int quantityB = 23;
        int quantityC = quantity - 1;
        for(int n = 0; n < quantity; n++)    {
            for(int b = quantityB; b > 0; b--) {
                System.out.print(" ");
            }
            quantityB--;
            for (int c = quantityC; c < quantity; c++) {
                System.out.print("#");
            }
            System.out.print("  ");
            for (int c = quantityC; c < quantity; c++) {
                System.out.print("#");
            }
            quantityC--;
            System.out.println();
        }
    }
}
