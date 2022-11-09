package com.cracker.algorithm.base;

import com.cracker.algorithm.base.struct.queue.BaseQueue;
import com.cracker.algorithm.base.struct.queue.CircularQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueTest {
    
    @Test
    void queueTest() {
        BaseQueue<Integer> queue = new BaseQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        assertEquals(1, queue.peek());
        int[] arr = {1, 2, 4, 3, 5, 6, 7};
        int[] index = {0};
        queue.stream().forEach(each -> assertEquals(arr[index[0]++], queue.dequeue()));
        assertEquals(0,queue.size());
    }

    @Test
    void circularQueue() {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        assertFalse(circularQueue.isFull());
        int[] ints = {1, 2, 3, 4};
        int[] index = {0};
        circularQueue.stream().forEach(each -> assertEquals(ints[index[0]++], each));
        circularQueue.enqueue(5);
        int[] ints2 = {1, 2, 3, 4, 5};
        index[0] = 0;
        assertTrue(circularQueue.isFull());
        circularQueue.stream().forEach(each -> assertEquals(ints2[index[0]++], each));
        circularQueue.enqueue(6);
        int[] ints3 = {2, 3, 4, 5, 6};
        index[0] = 0;
        assertTrue(circularQueue.isFull());
        circularQueue.stream().forEach(each -> assertEquals(ints3[index[0]++], each));
        assertEquals(2, circularQueue.front());
        assertEquals(6, circularQueue.rear());
        assertEquals(2, circularQueue.dequeue());
        assertFalse(circularQueue.isFull());
        int[] ints4 = {3, 4, 5, 6};
        index[0] = 0;
        circularQueue.stream().forEach(each -> assertEquals(ints4[index[0]++], each));
        System.out.println();
        assertEquals(3, circularQueue.front());
        assertEquals(6, circularQueue.rear());
        circularQueue.clear();
        assertTrue(circularQueue.isEmpty());
        assertFalse(circularQueue.isFull());
    }
}
