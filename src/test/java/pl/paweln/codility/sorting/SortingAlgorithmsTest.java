package pl.paweln.codility.sorting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class SortingAlgorithmsTest {
    private static final Logger logger = LogManager.getLogger();
    
    @Test
    public void testBubbleSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.bubbleSort(tab);
        logger.debug("Bubble sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testBubbleSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.bubbleSort(tab);
        logger.debug("Bubble sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testSelectionSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.selectionSort(tab);
        logger.debug("Selection sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testSelectionSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.selectionSort(tab);
        logger.debug("Selection sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testBackSelectionSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.selectionSortBackward(tab);
        logger.debug("Back selection sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testInsertionSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.insertionSort(tab);
        logger.debug("Insertion sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testInsertionSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.insertionSort(tab);
        logger.debug("Insertion sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testCountingSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.countingSort(tab);
        logger.debug("Counting sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testCountingSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.countingSort(tab);
        logger.debug("Counting sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testQuickSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.quickSort(tab);
        logger.debug("Quick sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testQuickSortSimpleHigherOnLeft() {
        int[] tab = { 9, 9, 9, 1, 2, 3, 4, 5, 6, 7};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 9, 9, 9};
        int opCount = SortingAlgorithms.quickSort(tab);
        logger.debug("Quick sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testQuickSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.quickSort(tab);
        logger.debug("Quick sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testHeapSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.heapSort(tab);
        logger.debug("Heap sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testHeapSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.heapSort(tab);
        logger.debug("Heap sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testMergeSortSimple() {
        int[] tab = { 5, 10, 15, 15, 10, 5, 1};
        int[] sorted = {1, 5, 5, 10, 10, 15, 15};
        int opCount = SortingAlgorithms.mergeSort(tab);
        logger.debug("Merge sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }

    @Test
    public void testMergeSort10000() {
        int size = 10000;
        int[] tab = new int[size];
        int[] sorted = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = size - i - 1;
            sorted[i] = i;
        }
        int opCount = SortingAlgorithms.mergeSort(tab);
        logger.debug("Merge sort of tab with size of " + tab.length + " operation count:" + opCount);
        Assert.assertArrayEquals (sorted, tab);
    }
}
