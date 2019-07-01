package com.qiqiji.backstage.game.demo;

public class Demo6 {

    /**
     * 手写冒泡排序法
     */
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        printArray(arr);
        System.out.println('\n'+"------------------");
        bubbleSort(arr);
        printArray(arr);

    }

    //冒泡排序
    static void bubbleSort(int[] arr) {
        //找规律!!!
        //第一轮排序
        for (int i=0; i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                int temp;
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        //第二轮排序
        for(int i = 0;i<arr.length-2;i++){
            if(arr[i]>arr[i+1]){
                int temp;
                temp =arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }

        }
        //第N轮排序
        for (int j = 1;j<arr.length-1;j++){
            for(int i = 0;i<arr.length-j;i++){
                if(arr[i]>arr[i+1]){
                    int temp;
                    temp =arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
    }

    //数组打印
    static void printArray(int[] arr) {
        for (int ele : arr){
            System.out.print(ele);
        }

    }

}
