package com.cracker.interview.basics.algorithm.base.struct.linked;

import com.cracker.interview.basics.algorithm.base.core.BaseStruct;

public abstract class Linked<I> extends BaseStruct<I> {
    
    /**
     * Appends the specified item to the end of this list.
     * @param item the item to attach to this list
     */
    public abstract void add(I item);
    
    /**
     * Inserts the specified item at the specified position in this list.
     * @param index the index to insert for the specified item
     * @param item the item to insert
     */
    public abstract void add(int index, I item);
    
    /**
     * Inserts the specified item at the beginning of this list.
     * @param item the item to add
     */
    public abstract void addFirst(I item);
    
    /**
     * Appends the specified element to the end of this list.
     * 
     * <p>This method is equivalent to {@link #add}.
     * @param item the item to add
     */
    public abstract void addLast(I item);
    
    /**
     * Returns the item at the specified location in this list.
     * @param index the index of the item to be returned
     * @return item in this list at the specified location
     */
    public abstract I get(int index);
    
    /**
     * Returns true if this list contains the specified item.
     * 
     * <p>More formally, return true if and only if this list contains at least one item E, making objects.equals(item, e).
     * @param item to test its items in this list
     * @return true if the list contains the specified item
     */
    public abstract boolean contains(I item);
    
    public abstract I remove(I item);
}
