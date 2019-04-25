package com.qiqiji.backstage.game.demo;

public class Demo12 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        //每次获取的对象相等,都是一个对象
        System.out.println(ArrayUtil.getInstance() == ArrayUtil.getInstance());
        ArrayUtil.getInstance().sort(arr);
        ArrayUtil.getInstance().sort(arr);
        ArrayUtil.getInstance().sort(arr);
    }
}

class ArrayUtil {
    /**
     * 单例设计模式,饿汉式
     */
    //1.必须在该类中自己先创建出一个对象
    private static ArrayUtil instance = new ArrayUtil();

    //2.私有化自身的构造器,防止外界通过构造器创建新的对象
    private ArrayUtil() {
    }

    //3.向外暴露一个公共的静态方法,用于获取自身的对象
    public static ArrayUtil getInstance() {
        return instance;
    }

    //任意方法
    public void sort(int[] arr) {
        System.out.println("一个方法");
    }
}
