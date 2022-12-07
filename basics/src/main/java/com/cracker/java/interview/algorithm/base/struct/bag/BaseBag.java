package com.cracker.java.interview.algorithm.base.struct.bag;

public class BaseBag<I> extends Bag<I> {

    @Override
    public void add(final I item) {
        linkLast(item);
    }
}
