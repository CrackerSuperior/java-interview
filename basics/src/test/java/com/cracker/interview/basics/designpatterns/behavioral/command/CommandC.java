package com.cracker.interview.basics.designpatterns.behavioral.command;

public class CommandC implements Command {
    
    @Override
    public void execute() {
        System.out.println("Executed command C!");
    }
}
