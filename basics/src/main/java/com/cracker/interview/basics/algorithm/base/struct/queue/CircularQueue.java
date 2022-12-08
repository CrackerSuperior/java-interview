package com.cracker.interview.basics.algorithm.base.struct.queue;

public class CircularQueue<I> extends Queue<I> {

    /**
     * The capacity of CircularQueue.
     */
    private final int length;

    public CircularQueue(final int length) {
        this.length = length;
    }

    /**
     * Get elements from the team leader.
     * @return Get elements from the team leader
     */
    public I front() {
        return peek();
    }

    /**
     * Gets the end of the queue element.
     * @return Gets the end of the queue element
     */
    public I rear() {
        return getLastItem();
    }

    /**
     * Inserts an element into the loop queue, and if the queue is full, the first element is displayed.
     * @param item item
     */
    public void enqueue(final I item) {
        if (isFull()) {
            dequeue();
        }
        linkLast(item);
    }

    public I dequeue() {
        return removeFirst();
    }

    public I peek() {
        return getFirstItem();
    }

    /**
     * Check if the loop queue is full.
     * @return Check if the loop queue is full
     */
    public boolean isFull() {
        return length == size();
    }
}
