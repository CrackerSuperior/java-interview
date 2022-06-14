package com.cracker.algorithm.sort.core;

public abstract class Sort<I> {

    private boolean reverse;

    protected Sort() { }

    protected Sort(final boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isReverse() {
        return reverse;
    }

    /**
     * Sorting method, each class must implement its own sorting method.
     * @param data dataset to be sorted
     */
    protected abstract void sort(Comparable<I>[] data);

    @SuppressWarnings("all")
    protected boolean less(final Comparable<I> x, final Comparable<I> y) {
        return x.compareTo((I) y) > 0;
    }

    protected void exch(final Comparable<I>[] data, final int i, final int j) {
        Comparable<I> t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * Check if the dataset is ordered.
     * @param data Detected dataset
     * @return check result
     */
    public boolean isSorted(final Comparable<I>[] data) {
        if (reverse) {
            for (int i = 1; i < data.length; i++) {
                if (less(data[i], data[i - 1])) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < data.length - 1; i++) {
                if (less(data[i], data[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
