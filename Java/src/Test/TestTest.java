package Test;

/**
 * Created by Dreawalker on 28.09.2016.
 */
public class TestTest {
    Integer i;
    Integer b;

    public TestTest(){}
    public TestTest(Integer i, Integer b) {
        this.i = i;
        this.b = b;
    }


    public static void main(String[] args) {
        TestTest test = new TestTest();
        System.out.println(test.i);
        System.out.println(test.b);
        test.changeNumber (test.i, test.b);
        System.out.println(test.i);
        System.out.println(test.b);
    }

    public void changeNumber (Integer i, Integer b) {
        this.i = i + 2;
        b = b + 4;
    }
}

