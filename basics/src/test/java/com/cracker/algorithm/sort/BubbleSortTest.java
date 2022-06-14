package com.cracker.algorithm.sort;

import com.cracker.algorithm.sort.sorts.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void test() {
        Integer[] data = {2, 5, 1, 3, 6, 9, 0, 8, 7, 4};
        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.sort(data);
        assert sort.isSorted(data);
        Arrays.stream(data).forEach(System.out::print);
        System.out.println();
        BubbleSort<Integer> sort1 = new BubbleSort<>(true);
        sort1.sort(data);
        assert sort1.isSorted(data);
        Arrays.stream(data).forEach(System.out::print);
    }
}
