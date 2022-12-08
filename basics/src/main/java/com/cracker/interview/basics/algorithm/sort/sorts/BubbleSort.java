package com.cracker.interview.basics.algorithm.sort.sorts;

import com.cracker.interview.basics.algorithm.sort.core.Sort;

public class BubbleSort<I> extends Sort<I> {

    public BubbleSort() { }

    public BubbleSort(final boolean reverse) {
        super(reverse);
    }

    @Override
    public void sort(final Comparable<I>[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (less(data[i], data[j])) {
                    exchange(data, i, j);
                }
            }
        }
    }
}
