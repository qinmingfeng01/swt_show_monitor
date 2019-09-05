package com.dtg.swt_monitor.shows.service;

import com.dtg.swt_monitor.shows.dao.ComprehensiveDao;
import com.dtg.swt_monitor.shows.entity.*;
import com.dtg.swt_monitor.shows.utils.AlarmsUtil;
import com.dtg.swt_monitor.shows.utils.CommonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: swt_monitor
 * @description: 综合服务层
 * @author: xiaozhile
 * @create: 2019-07-17 11:05
 **/
@Service
public class ComprehensiveService {
    @Resource
    private ComprehensiveDao comprehensiveDao;

    public List<CpuInfos> getAllCpuInfos(String currentIP01){
        return comprehensiveDao.getAllCpuInfos(currentIP01);
    }

    public List<Memory> getAllMenorys(String currentIP02){
        List<Memory> list = new ArrayList<>();
        List<Memory> allMenorys = comprehensiveDao.getAllMenorys(currentIP02);
        for (int i=0;i<allMenorys.size();i++){
            Memory memory = allMenorys.get(i);
            String totalAmount = memory.getTotalAmount();
            String useAmount = memory.getUseAmount();
            String totalCount = CommonUtil.getNum01(totalAmount);
            String useCount = CommonUtil.getNum01(useAmount);
            double tobalDouble = CommonUtil.toDouble(totalCount);
            double useDouble = CommonUtil.toDouble(useCount);
            double useRate = useDouble / tobalDouble;
            useRate = CommonUtil.getRateOfMemory(useRate);
            memory.setUseRate(useRate);
            list.add(memory);
        }
        return list;
    }

    public OprateSys getOprateSyss(String currentIP){
        List<OprateSys> oprateSyss = comprehensiveDao.getOprateSyss(currentIP);
        OprateSys oprateSys = null;
        if(oprateSyss.size()>0){
            oprateSys = oprateSyss.get(0);
        }
        return oprateSys;
    }

    public List<MyFile> getAllMyFiles(String currentIP){
        return comprehensiveDao.getAllMyFiles(currentIP);
    }

    public List<SafetyCheck> getSafetyChecks(String currentIP){
        return comprehensiveDao.getSafetyChecks(currentIP);
    }

    public Map<String,HardDisc> getHardDiscs(String currentIP){
        List<HardDisc> hardDiscs = comprehensiveDao.getHardDiscs(currentIP);
        Map<String,HardDisc> map = new HashMap<>();
        for (int i=0;i<hardDiscs.size();i++){
            HardDisc hardDisc = hardDiscs.get(i);
            String used = hardDisc.getUseAmount().replace("GB", "");
            String free = hardDisc.getFreeAmount().replace("GB", "");
            hardDisc.setUseAmount(used);
            hardDisc.setFreeAmount(free);
            if(hardDisc.getDevName().contains("C")){
                map.put("C",hardDisc);
            }else if(hardDisc.getDevName().contains("D")){
                map.put("D",hardDisc);
            }
        }
        return map;
    }

    public Map<String,List<String>> getAllComputerProcesss(String currentIP,String currentDate,int countFlag){
        Map<String,List<String>> map = new HashMap<>();
        List<ShowProcess> heXinList = new ArrayList<>();
        List<ShowProcess> administratorList = new ArrayList<>();
        List<ShowProcess> systemList = new ArrayList<>();
        List<ShowProcess> allComputerProcesss = comprehensiveDao.getAllComputerProcesss(currentIP,currentDate);

        for (int i=0;i<allComputerProcesss.size();i++){
            ShowProcess showProcess = allComputerProcesss.get(i);
            String processname = showProcess.getProcessname();
            double processsum = showProcess.getProcesssum();
            processsum = processsum / countFlag;
            showProcess.setProcesssum((int)processsum);
            if("核心进程".equals(processname)){
                heXinList.add(showProcess);
            }else if("Administrator".equals(processname)){
                administratorList.add(showProcess);
            }else if("SYSTEM".equals(processname)){
                systemList.add(showProcess);
            }
        }

        List<String> heXinDataList = new LinkedList<>();
        List<String> administratorDataList = new LinkedList<>();
        List<String> systemDataList = new LinkedList<>();
        List<String> xData = new LinkedList<>();
        for (int i=0;i<heXinList.size();i++){
            String heXinData = heXinList.get(i).getProcesssum()+"";
            String wctime = heXinList.get(i).getWctime()+"0";
            heXinDataList.add(heXinData);
            wctime = wctime.substring(11,wctime.length());
            xData.add(wctime);
        }
        for (int i=0;i<administratorList.size();i++){
            String administratorData = administratorList.get(i).getProcesssum()+"";
            administratorDataList.add(administratorData);
        }
        for (int i=0;i<systemList.size();i++){
            String systemData = systemList.get(i).getProcesssum()+"";
            systemDataList.add(systemData);
        }
        map.put("heXinDataList",heXinDataList);
        map.put("administratorDataList",administratorDataList);
        map.put("systemDataList",systemDataList);
        map.put("xData",xData);
        return map;
    }

    public CpuInfos getCpuInfo(String currentIP){
        return comprehensiveDao.getCpuInfo(currentIP);
    }

    public List<CpuTemperature> getAllCpuTemperature(String currentIP){
        return comprehensiveDao.getAllCpuTemperature(currentIP);
    }

    public SysOverview getSysOverview(String currentIP){
        return comprehensiveDao.getSysOverview(currentIP);
    }

    public List<SystemLogsVo> getAllSystemLogsVo(String currentIP){
        return comprehensiveDao.getAllSystemLogsVo(currentIP);
    }

    public List<ShowAlarm> getAlarms(){
        List<ShowAlarm> list = new ArrayList<>();
        Map<String,List<ShowAlarm>> map = new HashMap<>();
        List<ShowAlarm> alarms = comprehensiveDao.getAlarms();
        List<ShowAlarm> menoryList = new ArrayList<>();
        List<ShowAlarm> wenDuList = new ArrayList<>();
        List<ShowAlarm> sysLogsList = new ArrayList<>();
        List<ShowAlarm> safetyList = new ArrayList<>();
        for (ShowAlarm showAlarm:alarms) {
            String hardwareName = showAlarm.getHardwareName();
            if(hardwareName.contains("系统日志")){
                sysLogsList.add(showAlarm);
            }else if(hardwareName.contains("病毒扫描")){
                safetyList.add(showAlarm);
            }else if(hardwareName.contains("内存")){
                menoryList.add(showAlarm);
            }else {
                wenDuList.add(showAlarm);
            }
        }
        double menoryCount = 0;
        double wenDuCount = 0;
        double sysLogsCount = 0;
        double safetyCount = 0;


        ShowAlarm sysAlarm = null;
        ShowAlarm safetyAlarm = null;
        if(sysLogsCount != 0){
            sysAlarm = sysLogsList.get(0);
            sysAlarm.setResultData(sysLogsCount);
        }

        if(safetyCount != 0){
            safetyAlarm = safetyList.get(0);
            safetyAlarm.setResultData(safetyCount);
        }
        list.add(sysAlarm);
        list.add(safetyAlarm);
        return alarms;
    }

    public List<Map<String, Object>> getEveryIpData(){
        List<ShowAlarm> alarms = comprehensiveDao.getAlarms();
        //根据ip分类
        Map<String, List<ShowAlarm>> alarmsClassMap = AlarmsUtil.alarmsClass(alarms);
        //封装数据
        List<Map<String, Object>> list = AlarmsUtil.showAlarmFormat(alarmsClassMap);
        return list;
    }
}
