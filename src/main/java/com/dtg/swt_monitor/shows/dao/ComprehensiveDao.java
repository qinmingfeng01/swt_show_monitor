package com.dtg.swt_monitor.shows.dao;

import com.dtg.swt_monitor.shows.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: swt_monitor
 * @description: 综合持久层
 * @author: xiaozhile
 * @create: 2019-07-17 11:03
 **/
public interface ComprehensiveDao {
    //1.获取CPU列表
    public List<CpuInfos> getAllCpuInfos(@Param("currentIP01") String currentIP01);

    //2.获取内存列表
    public List<Memory> getAllMenorys(@Param("currentIP02") String currentIP02);

    //3.获取操作系统信息
    public List<OprateSys> getOprateSyss(@Param("currentIP03") String currentIP03);

    //4.获取文件监控信息
    public List<MyFile> getAllMyFiles(@Param("currentIP04") String currentIP04);

    //5.查杀日志记录
    public List<SafetyCheck> getSafetyChecks(@Param("currentIP05") String currentIP05);

    //6.查询硬盘信息
    public List<HardDisc> getHardDiscs(@Param("currentIP06") String currentIP06);

    //7.查询进程信息--现在没有当前时间的数据，所以先注释，后期还原
    public List<ShowProcess> getAllComputerProcesss(@Param("currentIP07") String currentIP07,@Param("currentDate") String currentDate);
    //public List<ShowProcess> getAllComputerProcesss(@Param("currentIP07") String currentIP07);

    //8.获取cpu信息
    public CpuInfos getCpuInfo(@Param("currentIP08") String currentIP08);

    //9.获取单条CpuTemperature的温度信息
    //public CpuTemperature getCpuTemperature(@Param("cpuTemperatureId") int id);

    //10.查询出数据库中所有的数据--符合条件的--目前测试用就取全部数据
    public List<CpuTemperature> getAllCpuTemperature(@Param("currentIP09") String currentIP09);

    //11.查询电脑信息概览
    public SysOverview getSysOverview(@Param("currentIP10") String currentIP);

    //12.获取系统日志
    public List<SystemLogsVo> getAllSystemLogsVo(@Param("currentIP11") String currentIP);

    /**
     * 13.设备预警，当天的
     * A:设备预警---内存80%
     * B:设备预警---CPU综合温度 70度
     * C:设备预警---系统日志（事件类型为error）
     * D:设备预警---病毒扫描（清除总数不为0）
     */
    public List<ShowAlarm> getAlarms();


}
