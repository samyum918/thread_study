package com.thread.study.waitNotify;

import java.util.Scanner;

public class Processor {
    public void produce() throws InterruptedException {
        //synchronize using the Processor lock
        synchronized (this) {
            System.out.println("Producer thread running...");
            //pasue the thread
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            //resume the consumer thread, if the lock is free
            notify();
            Thread.sleep(5000);
        }
    }
}
