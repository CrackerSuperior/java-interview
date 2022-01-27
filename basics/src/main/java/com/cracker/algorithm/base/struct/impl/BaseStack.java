package com.cracker.algorithm.base.struct.impl;

import com.cracker.algorithm.base.struct.Stack;

import java.util.NoSuchElementException;

public class BaseStack<I> extends Stack<I> {
    
    @Override
    public void push(final I item) {
        linkFirst(item);
    }
    
    @Override
    public I pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return removeFirst();
    }
    
    @Override
    public I peek() {
        return getFirstItem();
    }
}
