package com.cracker.interview.basics.algorithm.base.struct.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    /**
     * Check if the stack is full.
     * @return Check if the stack is full
     */
    public boolean isFull() {
        return number == items.length;
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
        return items[number - 1];
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
    
    @Override
    public Iterator<I> iterator() {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<I> {
    
        private int n = number;
        
        @Override
        public boolean hasNext() {
            return n > 0;
        }
    
        @Override
        public I next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[--n];
        }
    
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
