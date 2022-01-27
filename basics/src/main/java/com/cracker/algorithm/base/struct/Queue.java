package com.cracker.algorithm.base.struct;

import com.cracker.algorithm.base.common.BaseStruct;

public abstract class Queue<I> extends BaseStruct<I> {
    
    protected Queue() {
        super();
    }
    
    /**
     * Add an item to the queue.
     * @param item item
     */
    protected abstract void enqueue(I item);
    
    /**
     * Delete the earliest added element.
     * @return Delete the earliest added element
     */
    protected abstract I dequeue();
    
    /**
     * Returns the first element of the queue without removing it.
     * @return Returns the first element of the queue without removing it
     */
    protected abstract I peek();
}
