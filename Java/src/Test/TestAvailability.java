package Test;

import java.util.Arrays;

/**
 * Created by Bogdan on 21.06.2017.
 */
public class TestAvailability {
    public static void main(String[] args) {

        // primitive variable
        System.out.println("For primitive variable:");
        System.out.println();
        int i = 27;
        System.out.println("Before method invocation i = " + i);
        changeInt(i);
        System.out.println("After method invocation i = " + i);
        System.out.println();
        System.out.println();
        System.out.println();

        // immutable object variable
        System.out.println("For immutable object variable:");
        System.out.println();
        String string = "goro";
        System.out.println("Before method invocation string = " + string);
        changeString(string);
        System.out.println("After method invocation string = " + string);
        System.out.println();
        System.out.println();
        System.out.println();

        //mutable variable
        System.out.println("For mutable variable:");
        System.out.println();
        int[] ints = {4, 5, 6};
        System.out.println("Before method invocation ints = " + Arrays.toString(ints));
        changeArray(ints);
        System.out.println("After method invocation ints = " + Arrays.toString(ints));
        System.out.println();
        System.out.println();
        System.out.println();

        //wrapped primitive variable
        System.out.println("For wrapped primitive variable:");
        System.out.println();
        Double d = 25.0;
        System.out.println("Before method invocation d = " + d);
        changeDouble(d);
        System.out.println("After method invocation d = " + d);
        System.out.println();
        System.out.println();
        System.out.println();

        //custom mutable object variable
        System.out.println("For custom mutable object variable:");
        System.out.println();
        Person parson = new Person("Petia", 25);
        System.out.println("Before method invocation parson = " + parson);
        changePerson(parson);
        System.out.println("After method invocation parson = " + parson);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void changeInt(int i) {
        i = 2 + i;
        System.out.println("Inside method i = " + i);
    }

    public static void changeString(String string) {
        string = string + "baba";
        System.out.println("Inside method string = " + string);
    }

    public static void changeArray(int[] ints) {
        ints[0] = 90;
        System.out.println("Inside method ints = " + Arrays.toString(ints));
    }

    public static void changeDouble(Double d) {
        d = d + 35.4;
        System.out.println("Inside method d = " + d);
    }

    public static void changePerson(Person person) {
        person.setName("Alyosha");
        System.out.println("Inside method person = " + person);
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
