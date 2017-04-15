package sort;

/**
 * Created by Aditya on 24-02-2017.
 */
public class QuickSort {


    public <T extends Comparable> void sort(T[] array, int low, int high) {
        int pivot = partition(array, low, high);
        if (low < pivot - 1)
            sort(array, low, pivot - 1);
        if (pivot < high)
            sort(array, pivot, high);
    }

    private <T extends Comparable> int partition(T[] array, int low, int high) {
        int i = low;
        int j = high;
        T pivot = array[(low + high) / 2];
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
