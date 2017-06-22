package Test.Generics;

/**
 * Created by Bogdan on 22.06.2017.
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }

    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("name");
        String name = box.get();
    }
}
