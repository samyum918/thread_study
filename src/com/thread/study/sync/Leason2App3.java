package com.thread.study.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leason2App3 {
    private Random random = new Random();

    //Cannot use synchronized keyword in method stageOne and stageTwo
    //since there will use the only lock in Leason2App3 for both functions
    //which makes the running time slower
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for(int i=0; i<1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void doWork() {
        System.out.println("Starting...");

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            process();
        });

        Thread t2 = new Thread(() -> {
            process();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }

    public static void main(String[] args) {
        Leason2App3 app = new Leason2App3();
        app.doWork();
    }
}
