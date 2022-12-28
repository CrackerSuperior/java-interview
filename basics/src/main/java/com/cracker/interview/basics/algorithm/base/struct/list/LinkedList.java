package com.cracker.interview.basics.algorithm.base.struct.list;

/**
 * Duplicates the functionality of Class SinglyLinked.
 * @param <I> type of data
 */
public class LinkedList<I> extends List<I> {
    
    @Override
    public I get(final int index) {
        return getItem(node(index));
    }

    @Override
    public void add(final I item) {
        linkLast(item);
    }

    @Override
    public void add(final int index, final I item) {
        if (index == size()) {
            linkLast(item);
        } else {
            linkIndex(index, item);
        }
    }

    @Override
    public boolean contains(final I item) {
        return lastIndexOf(item) >= 0;
    }
}
