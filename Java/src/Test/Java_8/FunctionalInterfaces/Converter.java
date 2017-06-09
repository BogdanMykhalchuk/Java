package Test.Java_8.FunctionalInterfaces;

/**
 * Created by Bogdan on 09.06.2017.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
