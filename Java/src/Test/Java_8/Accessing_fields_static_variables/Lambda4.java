package Test.Java_8.Accessing_fields_static_variables;

import Test.Java_8.FunctionalInterfaces.Converter;

/**
 * Created by Bogdan on 09.06.2017.
 */
public class Lambda4 {
    public static int outerStaticNum;
    public int outerNum;

    public void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        String string1 = stringConverter1.convert(56);
        System.out.println(string1);

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }

    public static void main(String[] args) {
        Lambda4 lambda4 = new Lambda4();
        lambda4.testScopes();
        System.out.println(lambda4.outerNum);
    }
}
