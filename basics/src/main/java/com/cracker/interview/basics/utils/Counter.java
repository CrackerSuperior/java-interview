package com.cracker.interview.basics.utils;

import lombok.Getter;

@Getter
public class Counter {
    
    private final String id;
    
    private int value;
    
    public Counter(final String id) {
        this.id = id;
    }

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public void decrement() {
        synchronized (this) {
            value--;
        }
    }
    
    public int tally() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return "Counter{" + "id='" + id + '\'' + ", value=" + value + '}';
    }
}
