package com.cracker.algorithm.base.common;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Base<I> extends Iterable<I> {
    
    int size();
    
    default Stream<I> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
    
    @Override
    default Spliterator<I> spliterator() {
        return Spliterators.spliterator(this.iterator(), size(), 0);
    }
}
