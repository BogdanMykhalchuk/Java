package Test;

import java.io.IOException;

public final class TestTest {

    public static void main(String[] args)throws IOException{
        int i = TestTest.class.getModifiers();;
        byte j = (byte)i;
        int k = j & 0xFF;
        System.out.println(i);
    }
}


