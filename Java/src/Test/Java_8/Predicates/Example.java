package Test.Java_8.Predicates;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by Bogdan on 09.06.2017.
 */
class Example {
    public static void main(String[] args) {
        Predicate<String> predicate = (b) -> b.length() > 0;

        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
