package Harvard;

import java.util.ArrayList;

/**
 * Created by Dreawalker on 17.09.2016.
 */
public class Harvard_010_Sorting_Choise {
    public static void main(String[] args) {
        int[] array = {5, 89, 96, 47, 1, 2, 27, 1, 74, 65, 21, 1, 16};
        System.out.println(sortChoice(array).toString());
        System.out.println(sortChoice1(array).toString());
    }
    public static ArrayList sortChoice(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i : array) {
            arrayList.add(i);
        }

        for(int i = 1; i < arrayList.size(); i++) {
            int temp = arrayList.get(i - 1);
            for(int j = i; j < arrayList.size(); j++) {
                if(arrayList.get(j) < temp) {
                    temp = arrayList.get(j);
                }
            }
            arrayList.set(arrayList.subList(i - 1, arrayList.size()).indexOf(temp) + i - 1, arrayList.get(i - 1));
            arrayList.set(i - 1, temp);
        }

        return arrayList;
    }

    public static ArrayList sortChoice1(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i : array) {
            arrayList.add(i);
        }

        for(int i = 1; i < arrayList.size(); i++) {
            int temp = arrayList.get(i - 1);
            for(int j = i; j < arrayList.size(); j++) {
                if(arrayList.get(j) < temp) {
                    temp = arrayList.get(j);
                }
            }
            for(int z = i - 1; z < arrayList.size(); z++) {
                if(temp == arrayList.get(z)) {
                    arrayList.set(z, arrayList.get(i - 1));
                    break;
                }
            }
            arrayList.set(i - 1, temp);
        }

        return arrayList;
    }
}
