package Test.Java_8.FunctionalInterfaces.Method_Constructor_References;

import Test.Java_8.Accessing_fields_static_variables.Lambda4;
import Test.Java_8.FunctionalInterfaces.Converter;

import java.util.function.Predicate;

/**
 * Created by Bogdan on 09.06.2017.
 */
public class Processing {
    public static void main(String[] args) {
        Predicate<String> predicate = (b) -> b.length() > 0;

        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));
    }
}
