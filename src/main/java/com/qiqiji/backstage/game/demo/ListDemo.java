package com.qiqiji.backstage.game.demo;

import java.util.Arrays;

public class ListDemo {
    public static void main(String[] args) {
        //数组的静态初始化
        int[] ints = new int[]{1, 2, 3};
        //数组的动态初始化
        int[] ints1 = new int[3];
        System.out.println(ints.length);
        System.out.println(ints);
        System.out.println(ints[1]);
        System.out.println(ints == null);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println("数组中最大值为=" + getMax(ints));
        System.out.println(Arrays.toString(ints));
        System.out.println("逆序排序=" + Arrays.toString(sort(ints)));
    }

    //获取数组中的最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //数组的逆序排序
    public static int[] sort(int[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[arr.length - 1 - i] = arr[i];
        }
        return ints;
    }
}
