package com.cracker.algorithm.base.struct.stack;

import java.util.Arrays;

public class FixedCapacityStack<I> extends Stack<I> {
    
    private I[] items;
    
    private int number;
    
    @SuppressWarnings("unchecked")
    public FixedCapacityStack(final int cap) {
        items = (I[]) new Object[cap];
        number = 0;
    }
    
    @Override
    public void push(final I item) {
        if (number == items.length) {
            resize(items.length << 1);
        }
        items[number++] = item;
    }
    
    @Override
    public I pop() {
        I item = peek();
        items[--number] = null;
        if (number > 0 && number == items.length >> 2) {
            resize(items.length >> 1);
        }
        return item;
    }
    
    @Override
    public I peek() {
        return items[number-1];
    }
    
    @Override
    public boolean isEmpty() {
        return 0 == number;
    }
    
    @Override
    public int size() {
        return number;
    }
    
    @SuppressWarnings("unchecked")
    private void resize(final int max) {
        I[] temp = (I[]) new Object[max];
        final int[] i = {0};
        Arrays.stream(items).limit(number).forEach(each -> temp[i[0]++] = each);
        items = temp;
    } 
}
