package com.cracker.algorithm.sort.sorts;

import com.cracker.algorithm.sort.core.Sort;

public class SelectionSort<I> extends Sort<I> {

    public SelectionSort() {
    }

    public SelectionSort(final boolean reverse) {
        super(reverse);
    }

    @Override
    public void sort(final Comparable<I>[] data) {
        for (int i = 0; i < data.length; i++) {
            int mark = i;
            for (int j = i + 1; j < data.length; j++) {
                if (less(data[mark], data[j])) {
                    mark = j;
                }
            }
            exch(data, i, mark);
        }
    }
}
