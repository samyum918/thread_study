package com.thread.study.sync;

public class Leason2App2 {
    private int count = 0;

    //count = count + 1
    //1. Get count, 2. +1, 3. set new value to count
    //2 threads adding the same variable will override each other
    //Solution:
    //1. Use AtomicInteger and call increment method
    //2. Use synchronized keyword to lock the function
    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        Leason2App2 app = new Leason2App2();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        //Wait 2 threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }
}
