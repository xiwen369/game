package com.qiqiji.backstage.game.demo;

public class BreakDemo {
    public static void main(String[] args) {
        //了解break的作用
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3 ; j++) {
                if (i == 2){//终止当前for循环，这里终止的是他所在的for循环，并不影响他的外层嵌套的循环！！！
                    break;
                }
                System.out.println(i);
            }
        }
        System.out.println("------------------------------------------");
        //了解continue的作用
        for (int k = 0; k < 10; k++) {
            if (k == 3){//跳过本次循环，不影响当前for循环
                continue;
            }
            System.out.println(k);
        }
    }
}
