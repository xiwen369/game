package com.qiqiji.backstage.game.demo;

public class Demo7 {
    /**
     * 查找算法-二分法查找
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        banirySearch(arr, 7);
    }

    static int banirySearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length-1;
        int mid = 0;
//        //第一次查找
//        mid = (min + max) / 2;
//        if (arr[mid] > key) {
//            max = mid - 1;
//        } else if (arr[mid] < key) {
//            min = mid + 1;
//        } else {
//            return mid;
//        }
//        System.out.println(mid);
//        //第二次查找
//        mid = (min + max) / 2;
//        if (arr[mid] > key) {
//            max = mid - 1;
//        } else if (arr[mid] < key) {
//            min = mid + 1;
//        } else {
//            return mid;
//        }
//        System.out.println(mid);
        //第N次查找
        while (min<=max){
            mid = (min + max) / 2;
            if (arr[mid] > key) {
                max = mid - 1;
            } else if (arr[mid] < key) {
                min = mid + 1;
            } else {
                System.out.println(mid);
                return mid;
            }
        }
        return -1;
    }
}
