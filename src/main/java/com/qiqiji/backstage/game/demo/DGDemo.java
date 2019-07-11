package com.qiqiji.backstage.game.demo;

public class DGDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("i=" + i + ",fn=" + fn(i));
        }
    }

    //递归算法,计算斐波那切数列,f(0) = 0,f(1) = 1,f(n) = f(n-1)+f(n-2),n>=3,求f(5)?
    public static int fn(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fn(n - 1) + fn(n - 2);
        }
    }
}
