package com.qiqiji.backstage.game.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class demo3 {
    private static Logger logger = LoggerFactory.getLogger(demo3.class);
    public static void main(String[] args) {
        int a = 2;
        int b;
        b = a << 3;
        logger.info("b的值为:"+ b);
//        System.out.println(b);


    }

}
