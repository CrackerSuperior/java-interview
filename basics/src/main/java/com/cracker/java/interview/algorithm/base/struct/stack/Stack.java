package com.cracker.java.interview.algorithm.base.struct.stack;

import com.cracker.java.interview.algorithm.base.core.BaseStruct;

public abstract class Stack<I> extends BaseStruct<I> {
    
    /**
     * Add an item to the stack.
     * @param item item
     */
    public abstract void push(I item);
    
    /**
     * Deletes the most recently added element.
     * @return Deletes the most recently added element
     */
    public abstract I pop();
    
    /**
     * Returns the first element of the stack without removing it.
     * @return Returns the first element of the stack without removing it
     */
    public abstract I peek();
}
