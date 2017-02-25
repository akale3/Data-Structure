package sort;

import java.util.Arrays;

/**
 * Created by Aditya on 24-02-2017.
 */
public class SelectionSort {

    public <T> void sort(T[] array) {

        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            boolean minIndexFound = false;
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (((Comparable) array[j]).compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                    minIndexFound = true;
                }
            }
            if (minIndexFound) {
                swap(array, i, minIndex);
            }
        }
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
