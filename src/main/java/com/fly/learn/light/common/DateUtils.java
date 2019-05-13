package com.fly.learn.light.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/13 下午4:17
 * @Description:
 * @Modified:
 */
public class DateUtils {

    public static String format_accurate = "yyyy-MM-dd HH:mm:ss";

    public static String format = "yyyy-MM-dd";

    /**
     *@Author:Fly Created in 2019/5/13 下午4:21
     *@Description: 时间戳转时间
     */
    public static String stampToDateStr(long stamp, String format){

        return new SimpleDateFormat(format).format(new Date(stamp));
    }
}
