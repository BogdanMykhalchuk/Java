package Test;

import java.util.Arrays;

public class Test {
    public static void main(String args[]) {
        char[] chars = new char[95];
        for(int i = 0; i < 95; i++) {
            chars[i] = (char) (i + 32);
        }

        System.out.println(Arrays.toString(chars));
    }
}