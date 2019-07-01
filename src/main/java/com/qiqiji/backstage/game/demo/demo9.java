package com.qiqiji.backstage.game.demo;

public class demo9 {
    public static void main(String[] args) {
        String str1 = "xiwen";
        String str2 = "xiwen";
        System.out.println(str1==str2);

        String s1 = new String("xiwen");
        String s2 = new String("xiwen");
        System.out.println(s1==s2);

        System.out.println(str1.equals(str2));
        System.out.println(s1.equals(s2));

    }
}
