package com.cracker.algorithm.sort;

import com.cracker.algorithm.sort.sorts.BubbleSort;
import com.cracker.algorithm.sort.sorts.InsertionSort;
import com.cracker.algorithm.sort.sorts.SelectionSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortTest {

    @Test
    void bubbleSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        BubbleSort<Integer> sort = new BubbleSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        BubbleSort<Integer> sort1 = new BubbleSort<>(true);
        assertFalse(sort1.isSorted(integers));
        sort1.sort(integers);
        assertTrue(sort1.isSorted(integers));
        int[] ints2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        index[0] = 0;
        Arrays.stream(integers).forEach(each -> assertEquals(ints2[index[0]++], each));
    }

    @Test
    void selectionSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        SelectionSort<Integer> sort = new SelectionSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        SelectionSort<Integer> sort1 = new SelectionSort<>(true);
        assertFalse(sort1.isSorted(integers));
        sort1.sort(integers);
        int[] ints2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        index[0] = 0;
        assertTrue(sort1.isSorted(integers));
        Arrays.stream(integers).forEach(each -> assertEquals(ints2[index[0]++], each));
    }
    
    @Test
    void insertionSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        InsertionSort<Integer> sort = new InsertionSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        InsertionSort<Integer> sort1 = new InsertionSort<>(true);
        assertFalse(sort1.isSorted(integers));
        sort1.sort(integers);
        int[] ints2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        index[0] = 0;
        assertTrue(sort1.isSorted(integers));
        Arrays.stream(integers).forEach(each -> assertEquals(ints2[index[0]++], each));
    }
}
