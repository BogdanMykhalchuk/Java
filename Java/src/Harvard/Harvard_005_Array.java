package Harvard;

import Test.GetPositiveInt;

/**
 * Created by Dreawalker on 11.08.2016.
 */
public class Harvard_005_Array {
    public static void main(String[] args) {
        int n = GetPositiveInt.getPositiveInt("Введите количество человек: ");
        int[] age;
        age = new int[n];
        for(int i = 0; i < n; i++) {

            age[i] = GetPositiveInt.getPositiveInt("Введите возраст: ");
        }
        System.out.println(age);
        for(int i = 0; i < n; i++) {
            System.out.printf("Через год возраст человека №%d будет %d.\n", i + 1, age[i] + 1);
        }
    }
}
