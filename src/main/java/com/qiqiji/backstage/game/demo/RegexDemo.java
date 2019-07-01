package com.qiqiji.backstage.game.demo;

public class RegexDemo {
    public static void main(String[] args) {
        //正则表达式判断手机号码
        String input = "18302457318";
        String regex = "^1[3|4|5|7|8]\\d{9}$";
        System.out.println(input.matches(regex));
    }
}
