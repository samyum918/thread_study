package com.thread.study.interruptingThreads;

import java.util.Random;

public class Leason10App1 {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            Random ran = new Random();
            for(int i=0; i < 1E8; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                    break;
                }

                Math.sin(ran.nextDouble());
            }
        });

        t1.start();
        Thread.sleep(500);
        t1.interrupt();
        t1.join();

        System.out.println("Finished.");
    }
}
