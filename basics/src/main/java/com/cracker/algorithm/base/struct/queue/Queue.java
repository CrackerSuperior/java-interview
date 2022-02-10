package com.cracker.algorithm.base.struct.queue;

import com.cracker.algorithm.base.core.BaseStruct;

public abstract class Queue<I> extends BaseStruct<I> {
    
    /**
     * Add an item to the queue.
     * @param item item
     */
    public abstract void enqueue(I item);
    
    /**
     * Delete the earliest added element.
     * @return Delete the earliest added element
     */
    public abstract I dequeue();
    
    /**
     * Returns the first element of the queue without removing it.
     * @return Returns the first element of the queue without removing it
     */
    public abstract I peek();
}
