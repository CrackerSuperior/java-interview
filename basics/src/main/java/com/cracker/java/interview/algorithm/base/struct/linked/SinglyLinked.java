package com.cracker.java.interview.algorithm.base.struct.linked;

public class SinglyLinked<I> extends Linked<I> {
    
    @Override
    public void add(final I item) {
        addLast(item);
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
    public void addFirst(final I item) {
        linkFirst(item);
    }
    
    @Override
    public void addLast(final I item) {
        linkLast(item);
    }
    
    @Override
    public I get(final int index) {
        return getItem(node(index));
    }
    
    @Override
    public boolean contains(final I item) {
        return lastIndexOf(item) != -1;
    }

    @Override
    public I remove(final I item) {
        return remove(indexOf(item));
    }
}
