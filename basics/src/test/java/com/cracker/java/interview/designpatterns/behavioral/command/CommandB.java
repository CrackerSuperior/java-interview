package com.cracker.java.interview.designpatterns.behavioral.command;

public class CommandB implements Command {
    
    @Override
    public void execute() {
        System.out.println("Executed command B!");
    }
}
