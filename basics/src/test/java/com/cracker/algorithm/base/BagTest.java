package com.cracker.algorithm.base;

import com.cracker.algorithm.base.struct.bag.BaseBag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagTest {

    @Test
    void baseBagTest() {
        BaseBag<Integer> bag = new BaseBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        assertEquals(5, bag.size());
        int[] ints = {1, 2, 3, 4, 5};
        int[] index = {0};
        bag.stream().forEach(each -> {
            assertEquals(ints[index[0]++], each);
        });
        
    }
    
    @Test
    void baseBagTest2() {
        BaseBag<Double> numbers = new BaseBag<>();
        numbers.add(100d);
        numbers.add(99d);
        numbers.add(101d);
        numbers.add(120d);
        numbers.add(98d);
        numbers.add(107d);
        numbers.add(109d);
        numbers.add(81d);
        numbers.add(101d);
        numbers.add(90d);
        final double[] sum = {0.0};
        sum[0] = numbers.stream().reduce(Double::sum).orElseThrow(() -> new RuntimeException("未知错误"));
        double mean = sum[0] / numbers.size();
        sum[0] = 0.0;
        numbers.stream().forEach(each -> sum[0] += (each - mean) * (each - mean));
        double sqrt = Math.sqrt(sum[0] / (numbers.size() - 1));
        assertEquals("100.60", String.format("%.2f", mean));
        assertEquals("10.51", String.format("%.2f", sqrt));
    }
}
