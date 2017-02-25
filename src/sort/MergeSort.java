package sort;

import java.util.Objects;

/**
 * Created by Aditya on 24-02-2017.
 */
public class MergeSort {

    public <T> void sort(T[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(array, low, middle);
            sort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    private <T> void merge(T[] array, int low, int middle, int high) {
        T[] temp = (T[]) new Object[array.length];
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (((Comparable) array[i]).compareTo(array[j]) < 0) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            temp[k] = array[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = array[j];
            j++;
            k++;
        }
        for (i = low; i <= high; i++) {
            array[i] = temp[i];
        }
    }
}
