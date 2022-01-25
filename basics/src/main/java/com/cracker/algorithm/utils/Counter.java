package com.cracker.algorithm.utils;

public class Counter {
    
    private String id;
    
    private int number;
    
    public Counter(final String id) {
        this.id = id;
    }
    
    void increment() {
        number++;
    }
    
    int tally() {
        return this.number;
    }
    
    @Override
    public String toString() {
        return "Counter{" + "id='" + id + '\'' + ", number=" + number + '}';
    }
}
