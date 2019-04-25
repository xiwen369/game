package com.qiqiji.backstage.game.demo;

public class Demo5 {
    /**
     * java5新特性,可变参数
     * */
    public static void main(String[] args) {
       double sum =getSum(1,2,3,4,5);
        System.out.println(sum);
    }

    private static double getSum(double ... arr) {
        double sum = 0.0;
        for(double ele : arr){
            sum += ele;
        }
        return sum;
    }
}
