package com.cracker.interview.basics.designpatterns.behavioral.observer;

public abstract class Observer {
    
    private final Subject subject;
    
    protected Observer(final Subject subject) {
        this.subject = subject;
    }
    
    abstract void update();

    protected Subject getSubject() {
        return subject;
    }
}
