package com.thread.study.basic;

//Create thread by extend thread class
//Need to call start instead of run to start a new thread
//instead of the main thread
public class Leason1App1 {

    public static void main(String[] args) {
	    MyRunner runner1 = new MyRunner();
	    runner1.start();

        MyRunner runner2 = new MyRunner();
        runner2.start();
    }
}

class MyRunner extends Thread {
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