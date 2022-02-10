package com.cracker.algorithm.base.struct.bag;

import com.cracker.algorithm.base.core.BaseStruct;

public abstract class Bag<I> extends BaseStruct<I> {

    /**
     * Add an item to the bag.
     * @param item item
     */
    public abstract void add(I item);
}
