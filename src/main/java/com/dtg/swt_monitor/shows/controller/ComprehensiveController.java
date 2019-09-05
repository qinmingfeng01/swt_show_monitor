package com.dtg.swt_monitor.shows.controller;

import com.dtg.swt_monitor.shows.entity.*;
import com.dtg.swt_monitor.shows.service.ComprehensiveService;
import com.dtg.swt_monitor.shows.utils.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: swt_monitor
 * @description: 综合业务层
 * @author: xiaozhile
 * @create: 2019-07-17 11:02
 **/
@Controller
@RequestMapping(value = "/comprehensiveController")
public class ComprehensiveController {
    @Resource
    private ComprehensiveService comprehensiveService;


    /**
     * 跳转到监控页面
     */
    @RequestMapping(value = "/toCeShi")
    public String toCeShi(){
        return "b";
    }

    /**
     * 跳转到监控页面
     */
    @RequestMapping(value = "/toMonitorPage")
    public String toMonitorPage(){
        return "shows/om_monitor";
    }

    /**
     * 1.获取CPU信息列表
     */
    @RequestMapping(value = "/showDynamicCpuInfos")
    @ResponseBody
    public List<String[]> showDynamicCpuInfos(@RequestParam ("deviceip") String currentIP){
        //System.out.println("currentIP = " + currentIP);
        List<String[]> list = new ArrayList<>();
        //String currentIP = "192.168.50.7";
        List<CpuInfos> allCpuInfos = comprehensiveService.getAllCpuInfos(currentIP);
        int size = allCpuInfos.size();
        //System.out.println("size = " + size);

       /* int pageSize = 10;
        int startCs = pageSize * (countFlagInt - 1);
        System.out.println("startCs = " + startCs);
        int endCs = startCs + pageSize;
        System.out.println("endCs = " + endCs);
        String [] xArr = new String[pageSize];
        String [] yArr = new String[pageSize];
        if(countFlagInt < size){
            for (int i=startCs;i<endCs;i++){
                int j = 1;
                xArr[i] = j+"";
                j++;
            }
            for (int i=startCs;i<endCs;i++){
                yArr[i] = allCpuInfos.get(i).getUseRate().replace("%","");
            }
        }else {
            countFlagInt = 0;
        }*/
        String [] xArr = new String[size];
        String [] yArr = new String[size];
        for (int i=0;i<size;i++){
            xArr[i] = this.formart();
        }
        for (int i=0;i<size;i++){
            yArr[i] = allCpuInfos.get(i).getUseRate().replace("%","");
        }

        list.add(xArr);
        list.add(yArr);
        return list;
    }

    public String formart(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 2.获取内存信息
     */
    @RequestMapping(value = "showMenorys")
    @ResponseBody
    public List<String[]> showMenorys(@RequestParam ("deviceip") String currentIP){
        List<String[]> list = new ArrayList<>();
        //String currentIP = "192.168.50.7";
        List<Memory> allMenorys = comprehensiveService.getAllMenorys(currentIP);
        int size = allMenorys.size();
        //System.out.println("size = " + size);
        String [] xArr = new String[size];
        String [] yArr = new String[size];
        for (int i=0;i<size;i++){
            xArr[i] = this.formart();
        }
        for (int i=0;i<size;i++){
            double useRate = allMenorys.get(i).getUseRate();
            String useRateStr = CommonUtil.calculateMemory(useRate, i);
            yArr[i] = useRateStr;
        }
        list.add(xArr);
        list.add(yArr);
        return list;
    }

    /**
     * 3.获取操作系统信息
     */
    @RequestMapping(value = "/getOprateSysInfo")
    @ResponseBody
    public OprateSys getOprateSysInfo(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        OprateSys oprateSyss = comprehensiveService.getOprateSyss(currentIP);
        return oprateSyss;
    }

    /**
     * 4.展示文件监控信息
     */
    @RequestMapping(value = "/getAllMyFiles")
    @ResponseBody
    public List<MyFile> getAllMyFiles(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        List<MyFile> allMyFiles = comprehensiveService.getAllMyFiles(currentIP);
        List<MyFile> list = new ArrayList<>();
        for (int i=0;i<15;i++){
            MyFile myFile = allMyFiles.get(i);
            list.add(myFile);
        }
        return list;
    }

    /**
     * 5.展示查杀日志记录
     */
    @RequestMapping(value = "/showSafetyChecks")
    @ResponseBody
    public List<SafetyCheck> showSafetyChecks(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        List<SafetyCheck> safetyChecks = comprehensiveService.getSafetyChecks(currentIP);
        return safetyChecks;
    }

    /**
     * 6.显示硬盘信息
     */
    @RequestMapping(value = "/getHardDiscs")
    @ResponseBody
    public Map<String,HardDisc> getHardDiscs(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        Map<String, HardDisc> hardDiscMap = comprehensiveService.getHardDiscs(currentIP);
        //System.out.println("hardDiscMap = " + hardDiscMap);
        return hardDiscMap;
    }

    /**
     * 7.显示进程信息
     */
    @RequestMapping(value = "/showProcess")
    @ResponseBody
    public Map<String, List<String>> showProcess(@RequestParam ("deviceip") String currentIP){
        String result = "";
        //String currentIP = "192.168.50.7";
        String currentDate = CommonUtil.getCurrentDate();
        //这里的countFlag是取数据的次数，比如我是5秒入库一次，这里是10分钟读取一次，就是120次
        int countFlag = 120;
        Map<String,List<String>> allComputerProcesss = comprehensiveService.getAllComputerProcesss(currentIP, currentDate, countFlag);
        //System.out.println("allComputerProcesss = " + allComputerProcesss);
        return allComputerProcesss;
    }

    /**
     * 8.显示cpu信息
     */
    @RequestMapping(value = "showCpuInfos")
    @ResponseBody
    public CpuInfos showCpuInfos(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        return comprehensiveService.getCpuInfo(currentIP);
    }

    /**
     * 9.获取某一个时刻的温度值--测试用随机数（等正式确定以后再换成准确温度值）
     */
    @RequestMapping(value = "showCpuTemperature")
    @ResponseBody
    public CpuTemperature showCpuTemperature(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        List<CpuTemperature> allCpuTemperature = comprehensiveService.getAllCpuTemperature(currentIP);
        int size = allCpuTemperature.size();
        Random random = new Random();
        int id = random.nextInt(size);
        CpuTemperature cpuTemperature = allCpuTemperature.get(id);
        return cpuTemperature;
    }

    /**
     * 10.获取电脑信息概览
     */
    @RequestMapping(value = "showSysOverview")
    @ResponseBody
    public SysOverview showSysOverview(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        return comprehensiveService.getSysOverview(currentIP);
    }

    /**
     * 11.获取系统日志
     */
    @RequestMapping(value = "showSystemLogsVo")
    @ResponseBody
    public List<SystemLogsVo> showSystemLogsVo(@RequestParam ("deviceip") String currentIP){
        //String currentIP = "192.168.50.7";
        return comprehensiveService.getAllSystemLogsVo(currentIP);
    }

    /**
     * 12.监控报警
     */
    @RequestMapping(value = "showAlarms")
    @ResponseBody
    public List<Map<String, Object>> showAlarms(){
        List<Map<String, Object>> everyIpData = comprehensiveService.getEveryIpData();
//        for (Map<String,Object> map:everyIpData) {
//            System.out.println("map = " + map);
//        }
        return everyIpData;
    }

    /**
     * 13.获取切换时候的ip
     */
    @RequestMapping(value = "getShowIp")
    @ResponseBody
    public String getShowIp(@RequestParam ("deviceip") String currentIP, @RequestParam ("sxFlag") String sxFlag,HttpServletRequest request){
        String showIp = "";
        sxFlag = "1";
        HttpSession session = request.getSession();
        session.setAttribute("showIp",currentIP);
        session.setAttribute("sxFlag",sxFlag);
        Object showIp1 = session.getAttribute("showIp");
        return showIp;
    }

    /**
     * 14.清除缓存ip
     */
    @RequestMapping(value = "clearIp")
    @ResponseBody
    public void clearIp(HttpServletRequest request){
        request.getSession().removeAttribute("showIp");
        request.getSession().removeAttribute("sxFlag");
    }
}
