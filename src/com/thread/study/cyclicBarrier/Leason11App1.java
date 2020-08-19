package com.thread.study.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//CyclicBarrier: wait all threads to finish an operation (e.g. db insert)
//before running a later operation
public class Leason11App1 {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i = 0;i < N;i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" is inserting data...");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+" insertion complete. Waiting other threads to complete insertion");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("Insertion is completed for all threads. Continue to handle other operations.");
        }
    }
}
