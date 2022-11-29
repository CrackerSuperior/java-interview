package com.cracker.algorithm.sort.sorts;

import com.cracker.algorithm.sort.core.Sort;

public class ShellSort<I> extends Sort<I> {

    public ShellSort() { }
    
    public ShellSort(final boolean reverse) {
        super(reverse);
    }

    @Override
    public void sort(final Comparable<I>[] data) {
        int length = data.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(data[j - h], data[j]); j -= h) {
                    exchange(data, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
