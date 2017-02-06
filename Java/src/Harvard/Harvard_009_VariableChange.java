package Harvard;

/**
 * Created by Dreawalker on 16.09.2016.
 */
public class Harvard_009_VariableChange {
    public static void main(String[] args) throws Exception {
        int a = 8;
        int b = 9;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int i = 20;
        int j = 1000;
        int temp;

        temp = i;
        i = j;
        j = temp;

        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }
}
