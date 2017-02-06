package Harvard;

import java.util.Arrays;

/**
 * Created by Dreawalker on 19.09.2016.
 */
public class Harvard_014_BinarySearch {

    public static void main(String[] args) {
        int[] array = {5, 89, 96, 47, 1, 2, 27, 1, 74, 65, 21, 1, 16};
        Arrays.sort(array);
        System.out.println(binarySearch(74, array, 0, array.length - 1));
    }

    public static int binarySearch(int key, int[] array, int left, int right) {
        int midpoint;
        if(left > right) {
            return - 1;
        } else {
            midpoint = findMidpoint(left, right);
        }
        if(array[midpoint] > key) {
            return binarySearch(key, array, left, midpoint - 1);
        }
        if(array[midpoint] < key) {
            return binarySearch(key, array, midpoint + 1, right);
        }
        return array[midpoint];
    }

    public static boolean binarySearchBool(int key, int[] array, int left, int right) {
        int midpoint;
        if(left > right) {
            return false;
        } else {
            midpoint = findMidpoint(left, right);
        }
        if(array[midpoint] > key) {
            return binarySearchBool(key, array, left, midpoint - 1);
        }
        if(array[midpoint] < key) {
            return binarySearchBool(key, array, midpoint + 1, right);
        }
        if(array[midpoint] == key) {
            return true;
        } else {
            return false;
        }
    }

    public static int findMidpoint(int left, int right) {
        int midpoint = (left + right) / 2;
        return midpoint;
    }
}