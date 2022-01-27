package com.cracker.algorithm.base.struct;

import com.cracker.algorithm.base.common.BaseStruct;

public abstract class Bag<I> extends BaseStruct<I> {
    
    protected Bag() {
        super();
    }
    
    /**
     * Add an item to the bag.
     * @param item item
     */
    protected abstract void add(I item);
}
