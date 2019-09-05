package com.dtg.swt_monitor.buried.entity;

/**
 * @program: swt_monitor
 * @description: 安全检查详情实体：进程等
 * @author: xiaozhile
 * @create: 2019-07-10 16:31
 **/
public class SafetyCheckDetail {
    private String id;
    private String ip;
    private String zeroID;
    private String pid;
    private String processName;//进程名称
    private String runTime;//运行时间
    private String processPath;//进程所在位置
    private String processPathIsSafety;//进程扫描安全位置

    public SafetyCheckDetail(String id, String ip, String zeroID, String pid, String processName, String runTime, String processPath, String processPathIsSafety) {
        this.id = id;
        this.ip = ip;
        this.zeroID = zeroID;
        this.pid = pid;
        this.processName = processName;
        this.runTime = runTime;
        this.processPath = processPath;
        this.processPathIsSafety = processPathIsSafety;
    }

    public SafetyCheckDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getZeroID() {
        return zeroID;
    }

    public void setZeroID(String zeroID) {
        this.zeroID = zeroID;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getProcessPath() {
        return processPath;
    }

    public void setProcessPath(String processPath) {
        this.processPath = processPath;
    }

    public String getProcessPathIsSafety() {
        return processPathIsSafety;
    }

    public void setProcessPathIsSafety(String processPathIsSafety) {
        this.processPathIsSafety = processPathIsSafety;
    }

    @Override
    public String toString() {
        return "SafetyCheckDetail{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", zeroID='" + zeroID + '\'' +
                ", pid='" + pid + '\'' +
                ", processName='" + processName + '\'' +
                ", runTime='" + runTime + '\'' +
                ", processPath='" + processPath + '\'' +
                ", processPathIsSafety='" + processPathIsSafety + '\'' +
                '}';
    }
}
