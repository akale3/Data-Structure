package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Aditya on 24-02-2017.
 */
public class TestSort {


    @Test
    public void test_selection_sort() {
        Integer[] selectArray = {1, 43, 343, 123, 11, 4, 2};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(selectArray);
        Assert.assertEquals("Array is not sorted.", Arrays.toString(selectArray), "[1, 2, 4, 11, 43, 123, 343]");
    }

    @Test
    public void test_bubble_sort() {
        Integer[] bubbleArray = {1, 43, 343, 123, 11, 4, 2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(bubbleArray);
        Assert.assertEquals("Array is not sorted.", Arrays.toString(bubbleArray), "[1, 2, 4, 11, 43, 123, 343]");
    }

    @Test
    public void test_quick_sort() {
        int[] quickArray = {1, 43, 343, 123, 11, 4, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickArray, 0, quickArray.length - 1);
        Assert.assertEquals("Array is not sorted.", Arrays.toString(quickArray), "[1, 2, 4, 11, 43, 123, 343]");
    }

    @Test
    public void test_merge_sort() {
        MergeSort mergeSort = new MergeSort();
        Integer[] intArray = {1, 43, 343, 123, 11, 4, 2};
        mergeSort.sort(intArray, 0, intArray.length - 1);
        Assert.assertEquals("Array is not sorted.", Arrays.toString(intArray), "[1, 2, 4, 11, 43, 123, 343]");

        String[] stringArray = {"1", "43", "343", "123", "11", "4", "2"};
        mergeSort.sort(stringArray, 0, intArray.length - 1);
        Assert.assertEquals("Array is not sorted.", Arrays.toString(stringArray), "[1, 11, 123, 2, 343, 4, 43]");
    }

}
