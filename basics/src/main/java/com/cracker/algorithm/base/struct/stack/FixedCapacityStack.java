package com.cracker.algorithm.base.struct.stack;

public class FixedCapacityStack<I> extends Stack<I> {
    
    private final I[] items;
    
    private int number;
    
    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        Object[] objects = new Object[cap];
        items = (I[]) objects;
        number = 0;
    }
    
    @Override
    public void push(final I item) {
        items[number++] = item;
    }
    
    @Override
    public I pop() {
        return items[--number];
    }
    
    @Override
    public I peek() {
        return items[number];
    }
    
    @Override
    public boolean isEmpty() {
        return 0 == number;
    }
    
    @Override
    public int size() {
        return number;
    }
}
