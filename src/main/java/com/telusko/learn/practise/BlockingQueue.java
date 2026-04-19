package com.telusko.learn.practise;

import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

    private Queue<Integer> queue;
    private int capacity;
    private ReentrantLock lock;
    private Condition spacesAvailable;
    private Condition itemsAvailable;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        lock = new ReentrantLock();
        spacesAvailable = lock.newCondition();
        itemsAvailable = lock.newCondition();
    }

    public void put(int val) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                spacesAvailable.await();
            }
            queue.add(val);
            itemsAvailable.signal();
        } catch (Exception _) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }

    }

    public void get() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                itemsAvailable.await();
            }
            System.out.println(queue.poll());
            spacesAvailable.signal();
        } catch (Exception _) {

        } finally {
            lock.unlock();
        }
    }

    static void main() {
        BlockingQueue bq = new BlockingQueue(5);
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    bq.put(i);
                    System.out.println(System.currentTimeMillis() + "[Producer] Successfully put: " + i);
                    Thread.sleep(200); // Simulate some work
                }
            } catch (InterruptedException _) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(1000); // Slow consumer to force the queue to fill up
                    System.out.print(System.currentTimeMillis() + "[Consumer] Got: ");
                    bq.get();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}
