package com.thread.study.callableFuture;

import java.util.Random;
import java.util.concurrent.*;

//Callable: A runner which can return a value
//Future: Receive a value from callable
public class Leason9App1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if(duration > 2000) {
                    throw new IllegalArgumentException("Sleeping for too long.");
                }

                Thread.sleep(duration);

                System.out.println("Finished");

                return duration;
            }
        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
