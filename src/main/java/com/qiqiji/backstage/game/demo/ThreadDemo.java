package com.qiqiji.backstage.game.demo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static void main(String[] args) {
        //参数列表分别是(核心线程数,最大线程数,等待销毁时间,时间单位,阻塞队列(队列长度))
        ThreadPoolExecutor t = new ThreadPoolExecutor(1,3,3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3));
        t.execute(new dog());
        t.execute(new dog());
        t.execute(new dog());
        t.execute(new dog());
        t.execute(new dog());
        t.execute(new dog());
        t.execute(new dog());
        t.execute(new dog());
    }
    static class dog implements Runnable{
        @Override
        public void run() {
            System.out.println("狗儿叫");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
