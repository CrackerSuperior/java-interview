package com.cracker.interview.basics.designpatterns.behavioral.observer;

public class ObserverB extends Observer {

    public ObserverB(final Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println(getSubject().getClass().getName() + " notifies ObserverB that ObserverB has updated his status!");
    }
}
