package com.thread.study.basic;

public class Leason1App3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10; i++) {
                System.out.println("Hello" + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
    }
}
