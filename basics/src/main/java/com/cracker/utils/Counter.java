package com.cracker.utils;

public class Counter {
    
    private String id;
    
    private int number;
    
    public Counter(final String id) {
        this.id = id;
    }
    
    public void increment() {
        number++;
    }
    
    public int tally() {
        return this.number;
    }
    
    @Override
    public String toString() {
        return "Counter{" + "id='" + id + '\'' + ", number=" + number + '}';
    }
}
