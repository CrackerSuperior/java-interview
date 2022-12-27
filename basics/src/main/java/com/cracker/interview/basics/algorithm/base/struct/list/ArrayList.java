package com.cracker.interview.basics.algorithm.base.struct.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<I> implements List<I> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY = {};
    
    private int size;

    private Object[] items;
    
    public ArrayList() {
        items = new Object[DEFAULT_CAPACITY];
    }
    
    public ArrayList(final int capacity) {
        if (capacity > 0) {
            items = new Object[capacity];
        } else if (capacity == 0) {
            items = EMPTY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public I get(final int index) {
        checkIndex(index);
        return item(index);
    }

    @SuppressWarnings("unchecked")
    private I item(final int index) {
        return (I) items[index];
    }

    @Override
    public void add(final I item) {
        checkItem(item);
        checkSize();
        items[size++] = item;
    }

    @Override
    public void add(final int index, final I item) {
        checkItem(item);
        checkSize();
        checkIndex(index);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
    }

    private void checkSize() {
        if (size == items.length) {
            items = resize();
        }
    }

    private void checkItem(final I item) {
        if (item == null) {
            throw new NullPointerException("Item is null");
        }
    }

    private void checkIndex(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void set(final int index, final I item) {
        checkIndex(index);
        checkItem(item);
        items[index] = item;
    }
    
    private Object[] resize() {
        final Object[] newItems = new Object[size << 1];
        System.arraycopy(items, 0, newItems, 0, size);
        return newItems;
    }

    @Override
    public I remove(final int index) {
        checkIndex(index);
        final I item = item(index);
        final int newIndex;
        if ((newIndex = size - 1) > index) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        items[newIndex] = null;
        size--;
        return item;
    }

    @Override
    public boolean contains(final I item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(item(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<I> iterator() {
        return new ArrayListIterator<>(items, size);
    }
    
    private static class ArrayListIterator<I> implements Iterator<I> {

        private final Object[] items;
        
        private final int size;
        
        private int index;
        
        ArrayListIterator(final Object[] items, final int size) {
            this.items = items;
            this.size = size;
        }
        
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public I next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (I) items[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
