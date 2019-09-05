package com.dtg.swt_monitor.shows.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @program: swt_monitor
 * @description: 公共工具类
 * @author: xiaozhile
 * @create: 2019-07-18 10:00
 **/
public class CommonUtil {

    /**
     * 1.字符串转double
     */
    public static double toDouble(String s){
        return Double.parseDouble(s);
    }

    /**
     * 2.内存类使用--提取内存使用量的纯数字
     */
    public static String getNum01(String s){
        s = s.replace("GB","");
        return s;
    }

    /**
     * 内存使用--保留两位小数-生成百分率
     */
    public static double getRateOfMemory(double d){
        String s = (d*100)+"";
        s = s.substring(0,s.indexOf(".")+1);
        return Double.parseDouble(s);
    }

    /**
     * 获取当前时间
     */
    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 给读取出的内存随机增加或者减少 1-10之间的值
     */
    public static String calculateMemory(double num,int flag){
        String result = "72";
        Random random = new Random();
        int randomNum = random.nextInt(5);
        if(flag % 5 == 0){
            num += randomNum;
        }else {
            num -= randomNum;
        }
        result = num+"";
        return result;
    }

    /**
     * 获取当前时间02
     */
    public static String getCurrentDate02(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
