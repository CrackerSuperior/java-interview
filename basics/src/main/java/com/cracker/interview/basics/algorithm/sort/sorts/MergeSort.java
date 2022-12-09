package com.cracker.interview.basics.algorithm.sort.sorts;

import com.cracker.interview.basics.algorithm.sort.core.Sort;

public class MergeSort<I> extends Sort<I> {
    
    private I[] aux;

    public MergeSort() { }

    public MergeSort(final boolean reverse) {
        super(reverse);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sort(final Comparable<I>[] data) {
        aux = (I[]) (new Comparable[data.length]);
        sort(data, 0, data.length - 1);
    }
    
    private void sort(final Comparable<I>[] data, final int lo, final int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(data, lo, mid);
        sort(data, mid + 1, hi);
        merge(data, lo, mid, hi);
    }

    @SuppressWarnings("unchecked")
    private void merge(final Comparable<I>[] data, final int lo, final int mid, final int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = (I) data[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                data[k] = (Comparable<I>) aux[j++];
            } else if (j > hi) {
                data[k] = (Comparable<I>) aux[i++];
            } else if (less((Comparable<I>) aux[i], (Comparable<I>) aux[j])) {
                data[k] = (Comparable<I>) aux[j++];
            } else {
                data[k] = (Comparable<I>) aux[i++];
            }
        }
    }
}
