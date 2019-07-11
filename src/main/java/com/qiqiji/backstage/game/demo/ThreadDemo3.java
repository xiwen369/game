package com.qiqiji.backstage.game.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadDemo3 {
    //定时线程池
    public static void main(String[] args) {
        ScheduledExecutorService se = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            se.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 3, TimeUnit.SECONDS);
        }
    }
}