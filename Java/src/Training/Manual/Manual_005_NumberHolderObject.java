package Training.Manual;

/**
 * Created by Dreawalker on 26.07.2016.
 */
public class Manual_005_NumberHolderObject {
    public static void main (String[] args) {
        Manual_004_NumberHolder coordinate = new Manual_004_NumberHolder();
        coordinate.anInt = 5;
        coordinate.aFloat = 33.26f;
        System.out.println("anInt = " + coordinate.anInt);
        System.out.println("aFloat = " + coordinate.aFloat);
    }
}
