package com.qiqiji.backstage.game.demo;

public class Demo14 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        //每次获取的对象相等,都是一个对象
        EnumArrayUtil.INSTANCE.sort(arr);
        EnumArrayUtil.INSTANCE.sort(arr);
        EnumArrayUtil.INSTANCE.sort(arr);
    }
}

enum EnumArrayUtil{
    /**
     * 用枚举设计单例模式！
     */
    INSTANCE;
    //任意方法
    public void sort(int[] arr) {
        System.out.println("一个方法");
    }
}
