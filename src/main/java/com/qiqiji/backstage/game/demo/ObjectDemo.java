package com.qiqiji.backstage.game.demo;

public class ObjectDemo {
    //Object具有哪些方法?
    public static void main(String[] args) {
        Object o;
        o = "3306";
        System.out.println(o.hashCode());
        System.out.println(o.toString());
        System.out.println(o.getClass());
        String str = (String) o;
        System.out.println(str.toCharArray());

    }
}
