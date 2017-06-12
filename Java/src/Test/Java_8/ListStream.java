package Test.Java_8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dreawalker on 09.06.2017.
 */
public class ListStream {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("gay", 24));
        list.add(new Person("daddy", 36));
        list.add(new Person("cruiser", 48));
        list.add(new Person("daddy", 52));
        list.add(new Person("hell", 64));
        list.add(new Person("daddy", 18));

        list.stream().filter(s -> !s.getName().startsWith("d")).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

        list.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();

        list.forEach(System.out::println);

    }


    static class Person{
        String name;
        int age;

        Person(){}
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("name - %s; age - %d", name, age);
        }
    }
}
