package base;

import com.cracker.algorithm.base.impl.BaseBag;
import com.cracker.algorithm.imports.StdOut;
import org.junit.Test;

public class BagTest {
    //LinkedList
    @Test
    public void baseBagTest() {
        BaseBag<Integer> bag = new BaseBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        for(Integer i : bag) {
            System.out.println(i);
        }
    }
    
    @Test
    public void baseBagTest2() {
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
        StdOut.printf("Mean: %.2f\n", mean);//100.60
        StdOut.printf("Std dev: %.2f\n", sqrt);//10.51
    }
}
