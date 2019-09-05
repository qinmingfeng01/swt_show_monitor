package com.dtg.swt_monitor.buried.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @program: swt_monitor
 * @description: 公共工具类
 * @author: xiaozhile
 * @create: 2019-07-11 10:12
 **/
public class CommonUtil {

    public static String getCommonId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String formatDateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
