package com.cracker.algorithm.sort;

import com.cracker.algorithm.sort.sorts.BubbleSort;
import com.cracker.algorithm.sort.sorts.SelectionSort;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void bubbleSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        BubbleSort<Integer> sort = new BubbleSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        sort.sort(integers);
        assert sort.isSorted(integers);
        Arrays.stream(integers).forEach(System.out::print);
        System.out.println();
        BubbleSort<Integer> sort1 = new BubbleSort<>(true);
        sort1.sort(integers);
        assert sort1.isSorted(integers);
        Arrays.stream(integers).forEach(System.out::print);
    }

    @Test
    public void selectionSortTest() {
        int[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        SelectionSort<Integer> sort = new SelectionSort<>();
        Integer[] integers = Arrays.stream(data).boxed().toArray(Integer[]::new);
        sort.sort(integers);
        assert sort.isSorted(integers);
        Arrays.stream(integers).forEach(System.out::print);
        System.out.println();
        SelectionSort<Integer> sort1 = new SelectionSort<>(true);
        sort1.sort(integers);
        assert sort1.isSorted(integers);
        Arrays.stream(integers).forEach(System.out::print);
    }
}
