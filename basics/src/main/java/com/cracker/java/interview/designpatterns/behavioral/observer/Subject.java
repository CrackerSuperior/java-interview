package com.cracker.java.interview.designpatterns.behavioral.observer;

import com.cracker.java.interview.algorithm.base.struct.linked.Linked;
import com.cracker.java.interview.algorithm.base.struct.linked.SinglyLinked;

public abstract class Subject {
    
    private final Linked<Observer> observers = new SinglyLinked<>();
    
    public void attach(final Observer observer) {
        observers.add(observer);
    }

    public void detach(final Observer observer) {
        observers.remove(observer);
    }
    
    public void notice() {
        observers.forEach(Observer::update);
    }
}
