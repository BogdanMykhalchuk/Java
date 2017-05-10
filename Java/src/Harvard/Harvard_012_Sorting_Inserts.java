package Harvard;

import java.util.Arrays;

/**
 * Created by Dreawalker on 18.09.2016.
 */
public class Harvard_012_Sorting_Inserts {
    public static void main(String[] args) {
        int[] array = {5, 89, 96, 47, 1, 2, 27, 1, 74, 65, 21, 1, 16};
        System.out.println(Arrays.toString(sortInserts(array)));

    }
    public static int[] sortInserts(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                 }
            }
        }

        return array;
    }
}
