package Harvard;

/**
 * Created by Dreawalker on 16.09.2016.
 */
public class Harvard_008_Recurcion {
    public static void main(String[] args) throws Exception {
        int m = addNumber(50);
        System.out.println(m);

    }
    private static int addNumber(int m) {
        if(m <= 0) {
            return 0;
        } else {
            return (m + addNumber(m - 1));
        }
    }
}
