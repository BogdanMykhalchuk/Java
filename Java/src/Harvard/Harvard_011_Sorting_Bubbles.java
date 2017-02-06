package Harvard;
import java.util.Arrays;

/**
 * Created by Dreawalker on 18.09.2016.
 */
public class Harvard_011_Sorting_Bubbles {
    public static void main(String[] args) {
        int[] array = {5, 89, 96, 47, 1, 2, 27, 1, 74, 65, 21, 1, 16};
        sortBubbles(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sortBubbles(int[] array) {

        int count;
        do {
            count = 0;
            for(int i = 1; i < array.length; i++) {
                int temp;
                if(array[i - 1] > array[i]) {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    count++;
                }
            }
        } while(count > 0);

        return array;
    }
}
