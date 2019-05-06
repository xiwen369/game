package com.qiqiji.backstage.game.demo;

import java.util.Calendar;
import java.util.Date;

public class Demo17 {
    /**
     * 计算起止时间
     */
    public static void main(String[] args) {
        //需求：查询最近一周。。。。的信息，如何表示这一周？
        Date current = new Date();
        //创建一个Calendar实例
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        System.out.println("当前时间=" + c.getTime().toLocaleString());
        //把日增加一天，把时，分，秒变成0
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date endTime = c.getTime();
        c.add(Calendar.DAY_OF_MONTH,-7);
        Date beginTime = c.getTime();
        System.out.println("开始时间=" + beginTime.toLocaleString());
        System.out.println("结束时间=" + endTime.toLocaleString());

    }

}
