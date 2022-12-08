package com.cracker.interview.basics.designpatterns.behavioral.command;

public class CommandA implements Command {
    
    @Override
    public void execute() {
        System.out.println("Executed command A!");
    }
}
