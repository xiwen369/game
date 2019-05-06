package com.qiqiji.backstage.game.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo16 {
    public static void main(String[] args) throws ParseException {
        /**
         * 常用类Date的用法
         * */
        Date date = new Date();
        System.out.println(date);
        long time = System.currentTimeMillis();
        System.out.println(time);
        date = new Date(time);
        System.out.println(date);
        System.out.println(date.getTime());
        //中国风日期
        System.out.println(date.toLocaleString());
        //日期转字符串,字符串转日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = sdf.format(date);
        System.out.println(d);
        System.out.println(sdf.parse(d));

    }
}
