package com.cracker.java.interview.designpatterns.behavioral.chainofresponsibility;

public class HandlerA extends Handler {
    
    @Override
    public void doHandler() {
        System.out.println("I am Handler A, I have processed!");
    }
}
