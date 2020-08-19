package com.thread.study.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Leason3App1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0; i<5; i++) {
            executor.submit(new Processor(i));
        }

        //shutdown executor after all threads finished running
        executor.shutdown();

        System.out.println("All task submitted.");

        //Can run maximum 1 day
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All task completed.");
    }
}

class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }
}