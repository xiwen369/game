package com.qiqiji.backstage.game.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo3 {
    private static Logger logger = LoggerFactory.getLogger(Demo3.class);
    public static void main(String[] args) {
        int a = 2;
        int b;
        b = a << 3;
        logger.info("b的值为:"+ b);
        System.out.println(b);
    }
}
