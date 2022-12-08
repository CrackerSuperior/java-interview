package com.cracker.interview.basics.designpatterns;

import com.cracker.interview.basics.designpatterns.behavioral.chainofresponsibility.Handler;
import com.cracker.interview.basics.designpatterns.behavioral.chainofresponsibility.HandlerA;
import com.cracker.interview.basics.designpatterns.behavioral.chainofresponsibility.HandlerB;
import com.cracker.interview.basics.designpatterns.behavioral.chainofresponsibility.HandlerC;
import com.cracker.interview.basics.designpatterns.behavioral.command.CommandC;
import com.cracker.interview.basics.designpatterns.behavioral.observer.ObserverA;
import com.cracker.interview.basics.algorithm.base.struct.queue.BaseQueue;
import com.cracker.interview.basics.algorithm.base.struct.queue.Queue;
import com.cracker.interview.basics.designpatterns.behavioral.command.Command;
import com.cracker.interview.basics.designpatterns.behavioral.command.CommandA;
import com.cracker.interview.basics.designpatterns.behavioral.command.CommandB;
import com.cracker.interview.basics.designpatterns.behavioral.observer.ObserverB;
import com.cracker.interview.basics.designpatterns.behavioral.observer.Subject;
import com.cracker.interview.basics.designpatterns.behavioral.observer.SubjectA;
import org.junit.jupiter.api.Test;

class DesignPatternsTest {

    @Test
    void observerPatternTest() {
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
    void chainOfResponsibilityPatternTest() {
        Handler root = new HandlerA();
        root.add(new HandlerB());
        root.add(new HandlerC());
        root.handler();
    }
    
    @Test
    void CommandPatternTest() {
        Queue<Command> queue = new BaseQueue<>();
        queue.enqueue(new CommandA());
        queue.enqueue(new CommandB());
        queue.enqueue(new CommandC());
        queue.forEach(Command::execute);
    }
}
