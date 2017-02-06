package Habibulin;

/**
 * Created by Dreawalker on 29.06.2016.
 */
public class Habibulin_001_Array {
    public static void main(String[] args) {
        double a[] = {5.0, -2.1, 3.2, -1.1, 1.0}, aMin = a[a.length - 1], aMax = aMin;
        for (int i = a.length - 1; i > a.length - (a.length + 1); i--){
            if (a[i] < aMin) aMin = a[i];
            if (a[i] > aMax) aMax = a[i];
            System.out.println(aMin);
            System.out.println(aMax);
        }
        double range = aMax - aMin;
        System.out.println(range);
    }
}
