package com.cracker.algorithm.base.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class BaseStruct<I> implements Base<I> {
    
    private Node<I> first;
    
    private Node<I> last;
    
    private int number;
    
    protected BaseStruct() {
        first = null;
        last = null;
        number = 0;
    }
    
    public void linkLast(final I item) {
        Node<I> oldLast = last;
        last = getNode(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        number++;
    }
    
    public void linkFirst(final I item) {
        if (isEmpty()) {
             last = first;
        }
        Node<I> oldFirst = first;
        first = getNode(item);
        oldFirst.next = first;
        number++;
    }
    
    public I removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Struct underflow");
        }
        final I item = first.item;
        first = first.next;
        number--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    
    public Node<I> getFirst() {
        return first;
    }
    
    public I getFirstItem() {
        return getItem(getFirst());
    }
    
    public I getItem(final Node<I> node) {
        return node.item;
    }
    
    /**
     * Is the struct empty.
     * @return Is the struct empty
     */
    public boolean isEmpty() {
        return null == first;
    }
    
    /**
     * The number of elements in the struct.
     * @return The number of elements in the struct
     */
    @Override
    public int size() {
        return number;
    }
    
    @Override
    public Iterator<I> iterator() {
        return new LinkedIterator<>(first);
    }
    
    private Node<I> getNode(final I item) {
        Node<I> node;
        node = new Node<>();
        node.item = item;
        node.next = null;
        return node;
    }
    
    private static class Node<I> {
        
        private I item;
        
        private Node<I> next;
    }
    
    private static class LinkedIterator<I> implements Iterator<I> {
        
        private Node<I> current;
        
        LinkedIterator(final Node<I> first) {
            current = first;
        }
        
        @Override
        public boolean hasNext() {
            return null != current;
        }
        
        @Override
        public I next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            I item = current.item;
            current = current.next;
            return item;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
