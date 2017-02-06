package Harvard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Dreawalker on 26.10.2016.
 */
public class Harvard_015_RandomFillIntArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();
        int[] array = createAnArray(40);
        Harvard_011_Sorting_Bubbles.sortBubbles(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Harvard_014_BinarySearch.binarySearchBool(i, array, 0, array.length - 1));
    }

    public static int[] createAnArray(int sizeOfArray) {
        int[] array = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++) {
            int j = (int)(Math.random() * 10 + 1);
            array[i] = j;
        }

        return array;
    }
}
