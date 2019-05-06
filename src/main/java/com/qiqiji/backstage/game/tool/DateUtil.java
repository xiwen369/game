package com.qiqiji.backstage.game.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws ParseException {
        System.out.println(date2string(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(date2string(new Date(), "yyyy/MM/dd HH:mm:ss"));
        System.out.println(date2string(new Date(), "yyyy/MM/dd"));
        System.out.println(date2string(new Date(), null));
        System.out.println(date2string(new Date()));

        String date = "2019-05-06 17:01:57";
        System.out.println(string2date(date));
    }

    /**
     * 格式化操作
     * Date转String
     */
    public static String date2string(Date date) {
        return date2string(date, null);
    }

    public static String date2string(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (!EStringutil.INSTANCE.IsEmpty(pattern)) {
            pattern = DEFAULT_DATE_PATTERN;
        }
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    /**
     * 解析操作
     * String转Date
     */
    public static Date string2date(String date) throws ParseException {
        return string2date(date, null);
    }

    public static Date string2date(String date, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (!EStringutil.INSTANCE.IsEmpty(pattern)) {
            pattern = DEFAULT_DATE_PATTERN;
        }
        sdf.applyPattern(pattern);
        return sdf.parse(date);
    }
}
