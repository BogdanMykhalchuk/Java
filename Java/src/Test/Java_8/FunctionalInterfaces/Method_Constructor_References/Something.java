package Test.Java_8.FunctionalInterfaces.Method_Constructor_References;

import Test.Java_8.FunctionalInterfaces.Converter;

/**
 * Created by Bogdan on 09.06.2017.
 */
class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }
}
