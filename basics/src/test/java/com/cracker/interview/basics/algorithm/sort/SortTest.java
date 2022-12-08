package com.cracker.interview.basics.algorithm.sort;

import com.cracker.interview.basics.algorithm.base.struct.linked.Linked;
import com.cracker.interview.basics.algorithm.base.struct.linked.SinglyLinked;
import com.cracker.interview.basics.algorithm.sort.core.Sort;
import com.cracker.interview.basics.algorithm.sort.sorts.BubbleSort;
import com.cracker.interview.basics.algorithm.sort.sorts.InsertionSort;
import com.cracker.interview.basics.algorithm.sort.sorts.SelectionSort;
import com.cracker.interview.basics.algorithm.sort.sorts.ShellSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortTest {

    @Test
    void bubbleSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        Sort<Integer> sort = new BubbleSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        Sort<Integer> sort1 = new BubbleSort<>(true);
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
        Sort<Integer> sort = new SelectionSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        Sort<Integer> sort1 = new SelectionSort<>(true);
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
        Sort<Integer> sort = new InsertionSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        Sort<Integer> sort1 = new InsertionSort<>(true);
        assertFalse(sort1.isSorted(integers));
        sort1.sort(integers);
        int[] ints2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        index[0] = 0;
        assertTrue(sort1.isSorted(integers));
        Arrays.stream(integers).forEach(each -> assertEquals(ints2[index[0]++], each));
    }

    @Test
    void insertionSortXTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        InsertionSort<Integer> sort = new InsertionSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Assertions.assertFalse(sort.isSorted(integers));
        sort.sortX(integers);
        Assertions.assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        InsertionSort<Integer> sort1 = new InsertionSort<>(true);
        Assertions.assertFalse(sort1.isSorted(integers));
        sort1.sortX(integers);
        int[] ints2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        index[0] = 0;
        Assertions.assertTrue(sort1.isSorted(integers));
        Arrays.stream(integers).forEach(each -> assertEquals(ints2[index[0]++], each));
    }
    
    @Test
    void shellSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        Sort<Integer> sort = new ShellSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        assertFalse(sort.isSorted(integers));
        sort.sort(integers);
        assertTrue(sort.isSorted(integers));
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        Arrays.stream(integers).forEach(each -> assertEquals(ints[index[0]++], each));
        Sort<Integer> sort1 = new ShellSort<>(true);
        assertFalse(sort1.isSorted(integers));
        sort1.sort(integers);
        int[] ints2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        index[0] = 0;
        assertTrue(sort1.isSorted(integers));
        Arrays.stream(integers).forEach(each -> assertEquals(ints2[index[0]++], each));
    }

    /**
     * This is question 2.1.14 of the book "Algorithm4".
     */
    @Test
    void sortExperiment1() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        int first = 0;
        int second = 1;
        Linked<Integer> linked = new SinglyLinked<>();
        for (int i : data) {
            linked.add(i);
        }
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j <= data.length - i; j++) {
                if (linked.get(first) < linked.get(second)) {
                    linked.add(linked.remove(second));
                } else {
                    linked.add(linked.remove(first));
                }
            }
            for (int k = 1; k <= i; k++) {
                linked.add(linked.remove(first));
            }
        }
        linked.reverse();//If you want to sort from smallest to largest.
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] index = {0};
        linked.forEach(each -> Assertions.assertEquals(ints[index[0]++], each));
    }
}
