package com.cracker.algorithm.base.struct;

import com.cracker.algorithm.base.common.impl.BaseStruct;

public abstract class Bag<I> extends BaseStruct<I> {
    
    protected Bag() {
        super();
    }
    
    public I removeFirst() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Add an item to the bag.
     * @param item item
     */
    protected abstract void add(I item);
}
