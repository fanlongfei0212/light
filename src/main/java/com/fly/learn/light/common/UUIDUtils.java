package com.fly.learn.light.common;

import java.util.UUID;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/13 下午4:17
 * @Description: UUID工具类
 * @Modified:
 */
public class UUIDUtils {

    //最小值
    private static final int small = 100000;

    //最大值
    private static final int max = 999999;

    /**
     *@Author:Fly Created in 2019/5/13 下午4:18
     *@Description: 生成String类型的UUID
     */
    public static String getStrUUID(){

        String uuid = UUID.randomUUID().toString();

        return uuid.replaceAll("-", "").toUpperCase();
    }

    /**
     *@Author:Fly Created in 2019/5/13 下午4:22
     *@Description: 生成数字类型的字符串UUID
     */
    public static String getStrNumberUUID(){

        //时间戳
        long stamp = System.currentTimeMillis();

        //指定范围随机数
        int random = (int)(small+Math.random()*(max-small+1));

        //当前时间
        String dateStr = DateUtils
                .stampToDateStr(stamp, DateUtils.format_accurate)
                .replace("-", "")
                .replace(":", "")
                .replace(" ", "");

        return (dateStr + (stamp * random)).substring(0, 32);
    }
}
