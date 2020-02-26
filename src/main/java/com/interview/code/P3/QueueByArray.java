package com.interview.code.P3;

/**
 *  including push, pop, peek, empty methods.
 *  for queue the method maybe call enqueue, dequeue
 */
public class QueueByArray {

    private Object[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public QueueByArray(int capacity) {
        items = new Object[capacity];
        n = capacity;
    }

    public boolean enqueue(Object item) {
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public Object dequeue() {
        if (head == tail) return null;
        Object ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public boolean isEmpty(){
        return items.length == 0;
    }
}
