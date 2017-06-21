package Test;

import java.util.Arrays;

/**
 * Created by Bogdan on 21.06.2017.
 */
public class TestAvailability {
    public static void main(String[] args) {

        // local primitive variable
        int i = 27;
        System.out.println("Before method invocation i = " + i);
        setInt(i);
        System.out.println("After method invocation i = " + i);

        // local immutable object variable
        String string = "goro";
        System.out.println("Before method invocation string = " + string);
        setString(string);
        System.out.println("After method invocation string = " + string);

        //local mutable variable
        int[] ints = {4, 5, 6};
        System.out.println("Before method invocation ints = " + Arrays.toString(ints));
        setArray(ints);
        System.out.println("After method invocation ints = " + Arrays.toString(ints));
    }

    public static void setInt(int i) {
        i = 2 + i;
        System.out.println("Inside method i = " + i);
    }

    public static void setString(String string) {
        string = string + "baba";
        System.out.println("Inside method string = " + string);
    }

    public static void setArray(int[] ints) {
        ints[0] = 90;
        System.out.println("Inside method ints = " + Arrays.toString(ints));
    }
}
