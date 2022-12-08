package com.cracker.interview.basics.designpatterns.behavioral.chainofresponsibility;

public abstract class Handler {
    
    private Handler next;
    
    public Handler add(final Handler next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.add(next);
        }
        return next;
    }
    
    public void handler() {
        doHandler();
        if (next != null) {
            next.handler();
        }
    }
    
    public abstract void doHandler();
}
