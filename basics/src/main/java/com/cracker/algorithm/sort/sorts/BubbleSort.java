package com.cracker.algorithm.sort.sorts;

import com.cracker.algorithm.sort.core.Sort;

public class BubbleSort<I> extends Sort<I> {

    @Override
    public void sort(final Comparable<I>[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (!less(data[i], data[j])) {
                    exch(data, i, j);
                }
            }
        }
    }
}
