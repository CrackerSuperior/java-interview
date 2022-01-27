package base;

import com.cracker.algorithm.base.struct.queue.BaseQueue;
import org.junit.Test;

import java.util.Arrays;

public class QueueTest {
    
    @Test
    public void queueTest() {
        BaseQueue<Integer> queue = new BaseQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
    
        System.out.println(queue.peek());
    
        int size = queue.size();
        int[] arr = new int[size];
        final int[] i = {0};
        System.out.println(queue);
        queue.stream().forEach(each -> arr[i[0]++] = queue.dequeue());
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(queue.size());
        System.out.println(queue);
    }
}
