package com.cracker.algorithm.base.struct.stack;

import com.cracker.algorithm.base.common.BaseStruct;

public abstract class Stack<I> extends BaseStruct<I> {
    
    /**
     * Add an item to the stack.
     * @param item item
     */
    protected abstract void push(I item);
    
    /**
     * Deletes the most recently added element.
     * @return Deletes the most recently added element
     */
    protected abstract I pop();
    
    /**
     * Returns the first element of the stack without removing it.
     * @return Returns the first element of the stack without removing it
     */
    protected abstract I peek();
}
