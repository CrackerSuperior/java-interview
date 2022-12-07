package com.cracker.java.interview.algorithm.base;

import com.cracker.java.interview.algorithm.base.struct.stack.BaseStack;
import com.cracker.java.interview.algorithm.base.struct.stack.FixedCapacityStack;
import com.cracker.java.interview.algorithm.base.struct.stack.Stack;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {
    
    @Test
    void stackTest() {
        BaseStack<String> ops = new BaseStack<>();
        BaseStack<Double> vals = new BaseStack<>();
        String str = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        str.replace(" ","").chars().mapToObj(each -> String.valueOf((char)each)).forEach(each -> operation(ops, vals, each));
        assertEquals(101.0, vals.pop());
    }
    
    @Test
    void stackTest3() {
        FixedCapacityStack<String> ops = new FixedCapacityStack<>(1);
        FixedCapacityStack<Double> vals = new FixedCapacityStack<>(1);
        String str = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        str.replace(" ","").chars().mapToObj(each -> String.valueOf((char)each)).forEach(each -> operation(ops, vals, each));
        assertEquals(101.0, vals.pop());
    }
    
    private void operation(final Stack<String> ops, final Stack<Double> vals, final String each) {
        switch (each) {
            case "(":
            case "+":
            case "-":
            case "*":
            case "/":
                ops.push(each);
                break;
            case ")": {
                String op = ops.pop();
                double v = vals.pop();
                switch (op) {
                    case "+" :
                        v = v + vals.pop();
                        break;
                    case "-" :
                        v = v - vals.pop();
                        break;
                    case "*" :
                        v = v * vals.pop();
                        break;
                    case "/" : 
                        v = v / vals.pop();
                        break;
                    default :
                        throw new RuntimeException("未知字符: " + op);
                }
                vals.push(v);
                if (Objects.equals(ops.peek(), "(")) {
                    ops.pop();
                }
                break;
            }
            default:
                vals.push(Double.parseDouble(each));
        }
    }
    
    @Test
    void stackTest2() {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(1);
        String[] strings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that","-", "-", "-","is"};
        List<String> asList = Arrays.asList(strings);
        StringBuilder builder = new StringBuilder();
        asList.forEach(each -> {
            if (!each.equals("-")) {
                stack.push(each);
            } else if (!stack.isEmpty()) {
                builder.append(stack.pop()).append(" ");
            }
        });
        builder.append("(").append(stack.size()).append(" left on stack)");
        assertEquals("to be not that or be (2 left on stack)", builder.toString());
    }
}
