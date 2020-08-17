package com.thread.study.sync;

import java.util.Scanner;

public class Leason2App1 {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }
}

class Processor extends Thread {
    //volatile: prevent variable caching
    private volatile boolean running = true;

    public void run() {
        while(running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}