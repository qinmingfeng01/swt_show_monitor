package com.dtg.swt_monitor.buried.service;

import com.dtg.swt_monitor.buried.controller.SomprehensiveController;
import com.dtg.swt_monitor.buried.dao.*;
import com.dtg.swt_monitor.buried.entity.*;
import com.dtg.swt_monitor.buried.utils.*;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: swt_monitor
 * @description:综合服务层
 * @author: xiaozhile
 * @create: 2019-07-10 17:34
 **/
@Service
public class SomprehensiveService {
    private static Logger logger = LoggerFactory.getLogger(SomprehensiveService.class);

    @Resource
    private ISomprehensiveDao somprehensiveDao;

    /**
     * 1.进程入库
     */
    public int saveComputerProcess(){
        List<ComputerProcess> processList = ComputerProcessUtil.getJinChengList();
        return somprehensiveDao.saveComputerProcess(processList);
    }

    /**
     * 2.cpu入库
     */
    public int saveCpuInfos(){
        int saveFlag = 0;
        try{
            List<CpuInfos> cpuInfosList = ComputerMainInfoUtil.getCpuInfos();
            saveFlag = somprehensiveDao.saveCpuInfos(cpuInfosList);
        }catch (Exception e){
            logger.info("Exception = ",e);
        }
        return saveFlag;
    }

    /**
     * 3.硬盘入库
     */
    public int saveHardDisc(){
        int saveFlag = 0;
        try {
            List<HardDisc> hardDiscInfos = HardDiscJkUtil.getHardDiscInfos();
            saveFlag = somprehensiveDao.saveHardDisc(hardDiscInfos);
        }catch (Exception e){
            logger.info("Exception = ",e);
        }
        return saveFlag;
    }

    /**
     * 4.内存入库
     */
    public int saveMemory(){
        int saveFlag = 0;
        try {
            String id = CommonUtil.getCommonId();
            String ip = ComputerMainInfoUtil.getIpAddr();
            String memoryCount = ComputerMainInfoUtil.getMemoryCount();
            String useMemoryCount = ComputerMainInfoUtil.getUseMemoryCount();
            String freeMemoryCount = ComputerMainInfoUtil.getFreeMemoryCount();
            Memory memory = new Memory(id,ip,memoryCount,useMemoryCount,freeMemoryCount);
            saveFlag = somprehensiveDao.saveMemory(memory);
        }catch (Exception e){
            logger.info("Exception = ",e);
        }
        return saveFlag;
    }

    /**
     * 5.文件监听入库
     */
    public int saveMyFile(MyFile myFile){
        int saveFlag = 0;
        saveFlag = somprehensiveDao.saveMyFile(myFile);
        return saveFlag;
    }

    /**
     * 6.操作系统入库
     */
    public int saveOprateSys(){
        int saveFlag = 0;
        OprateSys oprateSys = ComputerMainInfoUtil.getOperateSystemInfo();
        saveFlag = somprehensiveDao.saveOprateSys(oprateSys);
        return saveFlag;
    }

    /**
     * 7.360安全检查入库
     */
    public int saveSafetyCheck(){
        int saveFlag = 0;
        List<SafetyCheck> safetyChecks = SafetyCheckUtil.getSafetyChecks();
        saveFlag = somprehensiveDao.saveSafetyCheck(safetyChecks);
        return saveFlag;
    }

    /**
     * 8.安全检查详情入库
     */
    public int saveSafetyCheckDetail(){
        int saveFlag = 0;
        List<SafetyCheckDetail> safetyCheckDetils = SafetyCheckUtil.getSafetyCheckDetils();
        saveFlag = somprehensiveDao.saveSafetyCheckDetail(safetyCheckDetils);
        return saveFlag;
    }
}
