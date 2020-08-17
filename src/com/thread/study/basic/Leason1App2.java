package com.thread.study.basic;

public class Leason1App2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnerable());
        Thread t2 = new Thread(new MyRunnerable());

        t1.start();
        t2.start();
    }
}

class MyRunnerable implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Hello" + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}