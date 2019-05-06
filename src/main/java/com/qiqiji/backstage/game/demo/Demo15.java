package com.qiqiji.backstage.game.demo;

import com.qiqiji.backstage.game.tool.EStringutil;

public class Demo15 {
    public static void main(String[] args) {
        String str = " ";
        System.out.println(EStringutil.INSTANCE.IsEmpty(str));
    }

    /**
     * 字符串的非空判断IsEmpty
     */
//   public static boolean IsEmpty(String str) {
//        if (str != null && !"".equals(str.trim())) {
//            return true;
//        }else{
//            return false;
//        }
//    }
    //优雅点
//    public static boolean IsEmpty(String str) {
//        if (str != null && !"".equals(str.trim())) {
//            return true;
//        }
//        return false;
//    }
    //高级点
//    public static boolean IsEmpty(String str) {
//        return str != null && !"".equals(str.trim());
//    }
}
