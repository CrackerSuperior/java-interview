package com.cracker.java.interview.designpatterns;

import com.cracker.java.interview.designpatterns.behavioral.chainofresponsibility.Handler;
import com.cracker.java.interview.designpatterns.behavioral.chainofresponsibility.HandlerA;
import com.cracker.java.interview.designpatterns.behavioral.chainofresponsibility.HandlerB;
import com.cracker.java.interview.designpatterns.behavioral.chainofresponsibility.HandlerC;
import com.cracker.java.interview.designpatterns.behavioral.observer.ObserverA;
import com.cracker.java.interview.designpatterns.behavioral.observer.ObserverB;
import com.cracker.java.interview.designpatterns.behavioral.observer.Subject;
import com.cracker.java.interview.designpatterns.behavioral.observer.SubjectA;
import org.junit.jupiter.api.Test;

class DesignPatternsTest {

    @Test
    void observerPatternsTest() {
        Subject subjectA = new SubjectA();
        ObserverA observerA = new ObserverA(subjectA);
        ObserverB observerB = new ObserverB(subjectA);
        
        subjectA.attach(observerA);
        subjectA.attach(observerB);
        subjectA.notice();
        
        subjectA.detach(observerB);
        subjectA.notice();
    }
    
    @Test
    void chainOfResponsibilityTest() {
        Handler root = new HandlerA();
        root.add(new HandlerB());
        root.add(new HandlerC());
        root.handler();
    }
}
