package com.cracker.algorithm.base;

public interface Bag<I> extends Base<I> {
    
    /**
     * Add an item to the bag.
     * @param item item
     * @return
     */
    void add(I item);
    
    /**
     * Is the backpack empty.
     * @return Is the backpack empty
     */
    boolean isEmpty();
    
    /**
     * The number of elements in the backpack.
     * @return The number of elements in the backpack
     */
    int size();
}
