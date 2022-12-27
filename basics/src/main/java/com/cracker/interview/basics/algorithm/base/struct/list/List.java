package com.cracker.interview.basics.algorithm.base.struct.list;

import com.cracker.interview.basics.algorithm.base.core.Base;

public interface List<I> extends Base<I> {
    
    I get(int index);
    
    void add(I item);

    void add(int index, I item);
    
    void set(int index, I item);
    
    I remove(int index);
    
    boolean contains(I item);
}
