package sort;

/**
 * Created by Aditya on 24-02-2017.
 */
public class BubbleSort {

    public <T> void sort(T array[]) {

        boolean isSorted;
        for (int i = 0; i < array.length - 1; i++) {
            isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (((Comparable) array[j + 1]).compareTo(array[j]) < 0) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
