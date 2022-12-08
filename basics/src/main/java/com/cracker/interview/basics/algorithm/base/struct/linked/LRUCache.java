package com.cracker.interview.basics.algorithm.base.struct.linked;

public class LRUCache<I> extends SinglyLinked<I> {
    //TODO: After Map is implemented, LRU is fully implemented.

    /**
     * Default cache size.
     */
    private static final int DEFAULT_CAPACITY = 10;
    
    private final int capacity;

    public LRUCache() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRUCache(final int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(final I item) {
        if (isFull()) {
            removeLast();
        }
        addFirst(item);
    }

    public I get() {
        return getFirstItem();
    }
    
    @Override
    public I get(final int key) {
        I item = remove(key);
        add(item);
        return item;
    }
    
    public boolean isFull() {
        return size() == capacity;
    }
}
