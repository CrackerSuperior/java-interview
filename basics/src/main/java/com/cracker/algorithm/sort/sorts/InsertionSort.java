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
    
    public void sortX(final Comparable<I>[] data) {
        int length = data.length;
        int exchanges = 0;
        for (int i = length - 1; i > 0; i--) {
            if (less(data[i - 1], data[i])) {
                exchange(data, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) {
            return;
        }
        for (int i = 2; i < length; i++) {
            Comparable<I> v = data[i];
            int j = i;
            while (less(data[j - 1], v)) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = v;
        }
    }
}
