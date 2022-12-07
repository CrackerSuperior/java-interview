package com.cracker.java.interview.designpatterns.behavioral.observer;

public class ObserverA extends Observer {

    public ObserverA(final Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println(getSubject().getClass().getName() + " notifies ObserverA that ObserverA has updated his status!");
    }
}
