package com.dtg.swt_monitor.buried.dao;

import com.dtg.swt_monitor.buried.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: swt_monitor
 * @description:
 * @author: xiaozhile
 * @create: 2019-07-10 17:29
 **/
public interface ISomprehensiveDao {

    //1.进程入库
    public int saveComputerProcess(@Param("processList") List<ComputerProcess> processList);

    //2.cpu入库
    public int saveCpuInfos(@Param("cpuInfosList") List<CpuInfos> cpuInfosList);

    //3.硬盘入库
    public int saveHardDisc(@Param("hardDiscList") List<HardDisc> hardDiscList);

    //4.内存入库
    public int saveMemory(@Param("memory") Memory memory);

    //5.文件变动入库
    public int saveMyFile(@Param("myFile") MyFile myFile);

    //6.操作系统入库
    public int saveOprateSys(@Param("oprateSys") OprateSys oprateSys);

    //7.安全检查入库
    public int saveSafetyCheck(@Param("safetyCheckList") List<SafetyCheck> safetyCheckList);

    //8.安全检查详情入库
    public int saveSafetyCheckDetail(@Param("safetyCheckDetailList") List<SafetyCheckDetail> safetyCheckDetailList);
}
