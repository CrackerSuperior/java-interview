package com.cracker.algorithm.base;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Bag<I> extends Iterable<I> {
    
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
    
    default Stream<I> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
    
    @Override
    default Spliterator<I> spliterator() {
        return Spliterators.spliterator(this.iterator(), size(), 0);
    }
}
