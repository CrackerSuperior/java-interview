package com.cracker.algorithm.base.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class BaseStruct<I> implements Base<I> {
    
    private Node<I> first;
    
    private Node<I> last;
    
    private int size;

    protected BaseStruct() {
        first = null;
        last = null;
        size = 0;
    }
    
    protected void linkFirst(final I item) {
        if (isEmpty()) {
            first = getNode(item);
            last = first;
        } else {
            Node<I> oldFirst = first;
            first = getNode(item);
            first.next = oldFirst;
        }
        size++;
    }
    
    protected void linkIndex(final int index, final I item) {
        if (0 == index) {
            linkFirst(item);
        } else if (size == index) {
            linkLast(item);
        } else {
            Node<I> newNode = getNode(item);
            Node<I> oldFirst = first;
            Node<I> oldNode = node(index);
            while (oldFirst.next == oldNode) {
                oldFirst = oldFirst.next;
            }
            oldFirst.next = newNode;
            newNode.next = oldNode;
            size++;
        }
    }
    
    protected void linkLast(final I item) {
        Node<I> oldLast = last;
        last = getNode(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }
    
    protected I removeFirst() {
        isEmptyCheck(isEmpty());
        final I item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    
    /**
     * Retrieves and deletes the header (the first item) of this list.
     * @return the head of this list
     */
    public I remove() {
        return removeFirst();
    }
    
    /**
     * Deletes the item at the specified position in this list.
     * 
     * <p>Shifts any subsequent item to the left (subtracting an item from the index).
     * 
     * <p>Returns the item removed from the list.
     * @param index the index of the item to be deleted
     * @return the item that was previously in the specified position
     */
    public I remove(final int index) {
        I result;
        if (0 == index) {
            result = removeFirst();
        } else if (size == index) {
            result = removeLast();
        } else {
            Node<I> oldFirst = first;
            Node<I> oldNode = node(index);
            while (oldFirst.next != oldNode) {
                oldFirst = oldFirst.next;
            }
            result = oldNode.item;
            oldFirst.next = oldNode.next;
            size--;
        }
        return result;
    }
    
    public I removeLast() {
        isEmptyCheck(isEmpty());
        final I item = last.item;
        Node<I> oldFirst = first;
        if (last == first) {
            first = last = null;
        } else {
            while (last != oldFirst.next) {
                oldFirst = oldFirst.next;
            }
            oldFirst.next = null;
            last = oldFirst;
        }
        size--;
        return item;
    }
    
    private void isEmptyCheck(final boolean empty) {
        if (empty) {
            throw new NoSuchElementException("Struct underflow");
        }
    }
    
    /**
     * Remove all elements from this struct.
     * 
     * <p>When this call returns, the list will be empty.
     */
    @SuppressWarnings("all")
    public void clear() {
        for (Node<I> x = first; x != null;) {
            Node<I> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
    
    /**
     * Replaces the item at the specified position in this list with the specified item.
     * @param index the index of the item to be replaced
     * @param item the item to be stored at the specified location
     * @return the item that was previously in the specified position
     */
    public I set(final int index, final I item) {
        Node<I> node = node(index);
        node.item = item;
        return node.item;
    }
    
    protected Node<I> getFirst() {
        return first;
    }
    
    protected Node<I> getLast() {
        return last;
    }
    
    protected I getFirstItem() {
        isEmptyCheck(isEmpty());
        return getItem(getFirst());
    }
    
    protected I getLastItem() {
        isEmptyCheck(isEmpty());
        return getItem(getLast());
    }
    
    protected I getItem(final Node<I> node) {
        return node.item;
    }
    
    /**
     * Returns the index of the specified item that first appears in this list, or -1 if the list does not contain the item.
     * 
     * <p>More formally, return the lowest index I such as objects.equals(item, get(I)), or -1 if there is no such index.
     * @param item the item to search for
     * @return the index of the specified item that first appears in this list, or -1 if the list does not contain the item
     */
    protected int indexOf(final I item) {
        int index = 0;
        if (null == item) {
            for (Node<I> i = first; i != null; i = i.next) {
                if (i.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<I> i = first; i != null; i = i.next) {
                if (item.equals(i.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
    
    /**
     * Returns the index of the last occurrence of the specified item in this list, or -1 if the list does not contain the item.
     * 
     * <p>More formally, return the highest exponent I such as objects.equals(item, get(I)), or -1 if there is no such exponent.  
     * @param item the item to search for
     * @return the index of the last occurrence of the specified item in this list, or -1 if the list does not contain the item
     */
    protected int lastIndexOf(final I item) {
        int index = -1;
        Node<I> oldFirst = first;
        while (oldFirst != null) {
            index = indexOf(item);
            oldFirst = oldFirst.next;
        }
        return index;
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
        return size;
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
    
    protected Node<I> node(final int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node<I> oldFirst = first;
        for (int i = 0; i < index; i++) {
            oldFirst = oldFirst.next;
        }
        return oldFirst;
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
