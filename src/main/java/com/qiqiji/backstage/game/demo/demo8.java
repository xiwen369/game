package com.qiqiji.backstage.game.demo;

import java.util.Arrays;

public class demo8 {
    /**
     * java自带的数组工具类
     */
    public static void main(String[] args) {
        //二分法查找
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = Arrays.binarySearch(arr, 8);
        System.out.println(index);

        //数组转String
        int[] arr1 = {4, 2, 7, 3, 9, 8, 0, 1, 5};
        String arrStr = Arrays.toString(arr1);
        System.out.println(arrStr);

        //数组的快速排序
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        //数组的复制
        int[] arr2 = Arrays.copyOf(arr1, 5);
        int[] arr3 = Arrays.copyOfRange(arr1, 2, 4);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

        Arrays.fill(arr,1);
        System.out.println(Arrays.toString(arr));

        Arrays.fill(arr,0,3,5);
        System.out.println(Arrays.toString(arr));
    }
}
