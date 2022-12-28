package com.cracker.interview.basics.algorithm.base.struct.list;

import com.cracker.interview.basics.algorithm.base.core.BaseStruct;

public abstract class List<I> extends BaseStruct<I> {
    
    public abstract I get(int index);
    
    public abstract void add(I item);

    public abstract void add(int index, I item);
    
    public abstract boolean contains(I item);
}
