package sort;

/**
 * Created by Aditya on 24-02-2017.
 */
public class QuickSort {


    public void sort(int[] array, int low, int high) {
        int pivot = partition(array, low, high);
        if (low < pivot - 1)
            sort(array, low, pivot - 1);
        if (pivot < high)
            sort(array, pivot, high);
    }

    private int partition(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[(low + high) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
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

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
