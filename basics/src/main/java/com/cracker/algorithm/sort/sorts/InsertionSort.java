package com.cracker.algorithm.sort.sorts;

import com.cracker.algorithm.sort.core.Sort;

public class InsertionSort<I> extends Sort<I> {

    public InsertionSort() { }

    public InsertionSort(final boolean reverse) {
        super(reverse);
    }

    @Override
    public void sort(final Comparable<I>[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0 && less(data[j - 1], data[j]); j--) {
                exchange(data, j, j - 1);
            }
        }
    }
}
