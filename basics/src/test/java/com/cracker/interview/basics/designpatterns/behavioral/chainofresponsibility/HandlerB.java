package com.cracker.interview.basics.designpatterns.behavioral.chainofresponsibility;

public class HandlerB extends Handler {
    
    @Override
    public void doHandler() {
        System.out.println("I am Handler B, I have processed!");
    }
}
