package com.qiqiji.backstage.game.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {
    public static String getStrMD5(String inStr) {
        // 获取MD5实例
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }

        // 将加密字符串转换为字符数组
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        // 开始加密
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] digest = md5.digest(byteArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            int var = digest[i] & 0xff;
            if (var < 16)
                sb.append("0");
            sb.append(Integer.toHexString(var));
        }
        return sb.toString();
    }
    public static String getconvertMD5(String inStr) {
        char[] charArray = inStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 't');
        }
        String str = String.valueOf(charArray);
        return str;
    }

    public static boolean passwordIsTure(String inputPwd,String dbPwd){
        String strMD5 = MD5Utils.getStrMD5(inputPwd);
        String jxPwd = MD5Utils.getconvertMD5(MD5Utils.getconvertMD5(dbPwd));
        return strMD5.equals(jxPwd);
    }
}
