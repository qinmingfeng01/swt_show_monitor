package com.dtg.swt_monitor.shows.utils;

import com.dtg.swt_monitor.shows.entity.ShowAlarm;
import org.apache.commons.collections.map.AbstractReferenceMap;

import java.util.*;

/**
 * @program: swt_monitor
 * @description: 报警工具类
 * @author: xiaozhile
 * @create: 2019-08-28 17:30
 **/
public class AlarmsUtil {

    /**
     * 1.把报警信息根据Ip分类
     */
    public static Map<String,List<ShowAlarm>> alarmsClass(List<ShowAlarm> list){
        Map<String,List<ShowAlarm>> map = new HashMap<>();
        for (ShowAlarm showAlarm:list) {
            String ip = showAlarm.getIp();
            if(map.containsKey(ip)){
                List<ShowAlarm> showAlarms = map.get(ip);
                showAlarms.add(showAlarm);
            }else{
                List<ShowAlarm> tempList = new ArrayList<>();
                tempList.add(showAlarm);
                map.put(ip,tempList);
            }
        }
        return map;
    }

    /**
     * 2.把数据封装成展示的格式（ip,数量）
     */
    public static List<Map<String, Object>> showAlarmFormat(Map<String,List<ShowAlarm>> paramMap){
            List<Map<String,Object>> list = new ArrayList<>();
        Set<String> strings = paramMap.keySet();
        List<String> paramStrList = new ArrayList<>(strings);
        for (int i=0;i<paramStrList.size();i++){
            String oneParam = paramStrList.get(i);
            List<ShowAlarm> showAlarms = paramMap.get(oneParam);
            Map<String, Object> everyIpDataMap = tjCount(showAlarms);
            list.add(everyIpDataMap);
        }
        return list;
    }

    /**
     * 3.统计每一个ip对应的报警部件的数量
     */
    public static Map<String,Object> tjCount(List<ShowAlarm> showAlarms){
        Map<String,Object> map = new HashMap<>();
        Map<String,Double> tempMap = new HashMap<>();
        List<ShowAlarm> menoryList = new ArrayList<>();
        List<ShowAlarm> wenDuList = new ArrayList<>();
        double menoryCount = 0;
        double wenDuCount = 0;
        double sysLogsCount = 0;
        double safetyCount = 0;
        String ip = showAlarms.get(0).getIp();
        for (int i=0;i<showAlarms.size();i++){
            ShowAlarm showAlarm = showAlarms.get(i);
            String hardwareName = showAlarm.getHardwareName();
            double resultData = showAlarm.getResultData();
            if(hardwareName.contains("内存")){
                menoryList.add(showAlarm);
            }else if(hardwareName.contains("温度")){
                wenDuList.add(showAlarm);
            }else if(hardwareName.contains("系统日志")){
                sysLogsCount += resultData;
            }else {
                safetyCount += resultData;
            }
        }
        menoryCount = menoryList.size();
        wenDuCount = wenDuList.size();
        tempMap.put("menory",menoryCount);
        tempMap.put("wendu",wenDuCount);
        tempMap.put("sysLogs",sysLogsCount);
        tempMap.put("safety",safetyCount);
        map.put("ip",ip);
        map.put("tempMap",tempMap);
        return map;
    }
}
