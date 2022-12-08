package com.cracker.interview.concurrency;

import com.cracker.interview.basics.utils.Counter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test; 

@Slf4j
class ConcurrencyTest {
    
    @Test
    void synchronizedTest() throws InterruptedException {
        Counter counter = new Counter("a");
        Thread a = new Thread(counter::increment, "a");
        Thread b = new Thread(counter::decrement, "b");
        a.start();
        b.start();
        a.join();
        b.join();
        log.debug("counter = {}", counter.getValue());
        Assertions.assertEquals(0, counter.getValue());
    }
}
