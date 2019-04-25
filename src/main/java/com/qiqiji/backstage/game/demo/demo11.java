package com.qiqiji.backstage.game.demo;


public class demo11 {
    public static void main(String[] args) {
        /**
         * 引用类型的强转和instanceof运算符
         * 问题:instanceof对于该对象和其父类返回的都是true,并不能准确的判断出,对象的真实类型
         *      通过getClass方法能够,准确的判断其真实类型
         * */
        Object object = "ABC";//把String对象赋值给Object对象
        System.out.println(object instanceof Object);
        System.out.println(object instanceof String);

        System.out.println(object.getClass());//获取对象的真实类型
        System.out.println(object.getClass()==String.class);
        System.out.println(object.getClass()==Object.class);


    }
}
