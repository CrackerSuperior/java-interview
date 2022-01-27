package com.cracker.algorithm.base.struct.bag;

public class BaseBag<I> extends Bag<I> {
    
    public BaseBag() {
        super();
    }
    
    @Override
    public void add(final I item) {
        linkLast(item);
    }
    
    @Override
    public I removeFirst() {
        throw new UnsupportedOperationException();
    }
}
