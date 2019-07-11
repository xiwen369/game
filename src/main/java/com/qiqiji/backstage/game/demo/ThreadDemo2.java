package com.qiqiji.backstage.game.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo2 {
    //定长线程池
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        es.shutdown();
    }
}
