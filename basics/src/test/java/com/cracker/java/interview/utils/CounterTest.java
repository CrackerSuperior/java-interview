package com.cracker.java.interview.utils;

import imports.StdOut;
import imports.StdRandom;
import org.junit.jupiter.api.Test;

class CounterTest {
    
    /**
     * Junit 不能使用手动输入，会一直转圈执行不了代码.
     */
    @Test
    void flips() {
        int time = 1000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < time; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        StdOut.println(heads);
        StdOut.println(tails);
        StdOut.println(max(heads, tails) + " wins!");
        StdOut.println("delta: " + Math.abs(heads.tally() - tails.tally()));
    }
    
    public static Counter max(Counter x, Counter y) {
        return x.tally() > y.tally() ? x : y;
    }
}
