package com.cracker.algorithm.base;

import com.cracker.algorithm.base.struct.queue.BaseQueue;
import com.cracker.algorithm.base.struct.queue.CircularQueue;
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
        System.out.println("queue1 = " + queue);
        queue.stream().forEach(each -> arr[i[0]++] = queue.dequeue());
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("size = " + queue.size());
        System.out.println("queue2 = " + queue);
    }

    @Test
    public void circularQueue() {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        System.out.println(circularQueue.isFull());
        circularQueue.stream().forEach(System.out::print);
        System.out.println();
        circularQueue.enqueue(5);
        System.out.println(circularQueue.isFull());
        circularQueue.stream().forEach(System.out::print);
        System.out.println();
        circularQueue.enqueue(6);
        System.out.println(circularQueue.isFull());
        circularQueue.stream().forEach(System.out::print);
        System.out.println();
        System.out.println(circularQueue.front());
        System.out.println(circularQueue.rear());
        circularQueue.dequeue();
        System.out.println(circularQueue.isFull());
        circularQueue.stream().forEach(System.out::print);
        System.out.println();
        System.out.println(circularQueue.front());
        System.out.println(circularQueue.rear());
        circularQueue.clear();
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isFull());
        circularQueue.stream().forEach(System.out::println);
    }
}
