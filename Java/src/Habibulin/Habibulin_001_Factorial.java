package Habibulin;

/**
 * Created by Dreawalker on 28.06.2016.
 */
public class Habibulin_001_Factorial {
    public static void main(String[] args) {
        double b = 95;
        double x = 1;
        double a = 0;
        for (double i = 1; i < b + 1; i++) {
            x = x * (a + 1);
            a++;
            System.out.println("Итерация " + i + ", a = " + a + ", x = " + x);
        }
        System.out.println("Факториал числа " + b + " = " + x);

        b = 3;
        double y = 2;
        double i = 0;
        a = 1;
        while (i <= b) {
            if (y * a > b) {
                System.out.println("Результат i = " + i);
                break;
            }
            y = y * a;
            a = 2;
            i++;
            System.out.println("Итерация " + i + ", y = " + y + ", i = " + i);
        }
    }
}
