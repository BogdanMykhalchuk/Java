package Harvard;

import java.util.Arrays;

/**
 * Created by Dreawalker on 19.09.2016.
 */
public class Harvard_013_Sorting_Merge {
    public static void main(String[] args) {
        int[] array = {5, 89, 96, 47};
        sortMerge(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void sortMerge(int[] array, int start, int end) {
            if(end > start) {
                int middle = start + (end - start) / 2;
                sortMerge(array, start, middle);
                sortMerge(array, middle + 1, end);
                merge(array, start, middle, middle + 1, end);
            }
    }

    public static void merge(int[] array, int start, int firstEnd, int secondStart, int end) {
        int temp;
        if(array[start] > array[firstEnd + 1]) {
            temp = array[start];
            array[start] = array[firstEnd + 1];
            array[firstEnd + 1] = temp;
        }
        if(array[secondStart - 1] > array[end]) {
            temp = array[secondStart - 1];
            array[secondStart - 1] = array[end];
            array[end] = temp;
        }

        if(array[firstEnd + 1] > array[secondStart - 1]) {
            temp = array[firstEnd + 1];
            array[firstEnd + 1] = array[secondStart - 1];
            array[secondStart - 1] = temp;
            merge(array, start, firstEnd, secondStart, end);
        }
    }
}
