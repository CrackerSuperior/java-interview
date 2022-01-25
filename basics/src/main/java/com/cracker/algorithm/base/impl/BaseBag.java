package com.cracker.algorithm.base.impl;

import com.cracker.algorithm.base.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BaseBag<I> implements Bag<I> {
    
    private int number;
    
    private Node<I> first;
    
    public BaseBag() {
        this.number = 0;
        this.first = null;
    }
    
    @Override
    public void add(final I item) {
        Node<I> temp = first;
        if (null == temp) {
            temp = getNode(item);
            first = temp;
        } else {
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = getNode(item);
        }
        this.number++;
    }
    
    private Node<I> getNode(final I item) {
        Node<I> node;
        node = new Node<>();
        node.item = item;
        node.next = null;
        return node;
    }
    
    @Override
    public boolean isEmpty() {
        return null == this.first;
    }
    
    @Override
    public int size() {
        return this.number;
    }
    
    @Override
    public Iterator<I> iterator() {
        return new LinkedIterator(this.first);
    }
    
    private static class Node<I> {
        
        private I item;
        
        private Node<I> next;
    }
    
    private class LinkedIterator implements Iterator<I> {
        
        private Node<I> current;
        
        LinkedIterator(final Node<I> first) {
            this.current = first;
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
