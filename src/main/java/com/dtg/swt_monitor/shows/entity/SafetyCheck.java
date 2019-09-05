package com.dtg.swt_monitor.shows.entity;

/**
 * @program: swt_monitor
 * @description: 安全检查实体：杀毒，防护等
 * @author: xiaozhile
 * @create: 2019-07-10 11:06
 **/
public class SafetyCheck {
    private String id;
    private String ip;
    private String scanTime;//扫描时间
    private String useTime;//扫描用时
    private String scanType;//快速扫描
    private String scanTotalFileCount;//扫描文件总数
    private String projectTotalNum;//项目总数
    private String clearCount;//清除项目数
    private String isScanAll;//是否扫描所有文件
    private String isScanCompressPackge;//是否扫描压缩包
    private String processType;//处理方式：由用户选择处理
    private String isScanHardDisc;//是否扫描硬盘
    private String isScanRootkit;
    private String isYunchaKill;//是否使用云查杀
    private String isRepair;//是否建议修复项
    private String conventionalEngines;//常规引擎
    private String scanContent;//扫描内容

    public SafetyCheck(String id, String ip, String scanTime, String useTime, String scanType, String scanTotalFileCount, String projectTotalNum, String clearCount, String isScanAll, String isScanCompressPackge, String processType, String isScanHardDisc, String isScanRootkit, String isYunchaKill, String isRepair, String conventionalEngines, String scanContent) {
        this.id = id;
        this.ip = ip;
        this.scanTime = scanTime;
        this.useTime = useTime;
        this.scanType = scanType;
        this.scanTotalFileCount = scanTotalFileCount;
        this.projectTotalNum = projectTotalNum;
        this.clearCount = clearCount;
        this.isScanAll = isScanAll;
        this.isScanCompressPackge = isScanCompressPackge;
        this.processType = processType;
        this.isScanHardDisc = isScanHardDisc;
        this.isScanRootkit = isScanRootkit;
        this.isYunchaKill = isYunchaKill;
        this.isRepair = isRepair;
        this.conventionalEngines = conventionalEngines;
        this.scanContent = scanContent;
    }

    public SafetyCheck() {
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

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanTotalFileCount() {
        return scanTotalFileCount;
    }

    public void setScanTotalFileCount(String scanTotalFileCount) {
        this.scanTotalFileCount = scanTotalFileCount;
    }

    public String getProjectTotalNum() {
        return projectTotalNum;
    }

    public void setProjectTotalNum(String projectTotalNum) {
        this.projectTotalNum = projectTotalNum;
    }

    public String getClearCount() {
        return clearCount;
    }

    public void setClearCount(String clearCount) {
        this.clearCount = clearCount;
    }

    public String getIsScanAll() {
        return isScanAll;
    }

    public void setIsScanAll(String isScanAll) {
        this.isScanAll = isScanAll;
    }

    public String getIsScanCompressPackge() {
        return isScanCompressPackge;
    }

    public void setIsScanCompressPackge(String isScanCompressPackge) {
        this.isScanCompressPackge = isScanCompressPackge;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getIsScanHardDisc() {
        return isScanHardDisc;
    }

    public void setIsScanHardDisc(String isScanHardDisc) {
        this.isScanHardDisc = isScanHardDisc;
    }

    public String getIsScanRootkit() {
        return isScanRootkit;
    }

    public void setIsScanRootkit(String isScanRootkit) {
        this.isScanRootkit = isScanRootkit;
    }

    public String getIsYunchaKill() {
        return isYunchaKill;
    }

    public void setIsYunchaKill(String isYunchaKill) {
        this.isYunchaKill = isYunchaKill;
    }

    public String getIsRepair() {
        return isRepair;
    }

    public void setIsRepair(String isRepair) {
        this.isRepair = isRepair;
    }

    public String getConventionalEngines() {
        return conventionalEngines;
    }

    public void setConventionalEngines(String conventionalEngines) {
        this.conventionalEngines = conventionalEngines;
    }

    public String getScanContent() {
        return scanContent;
    }

    public void setScanContent(String scanContent) {
        this.scanContent = scanContent;
    }

    @Override
    public String toString() {
        return "SafetyCheck{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", scanTime='" + scanTime + '\'' +
                ", useTime='" + useTime + '\'' +
                ", scanType='" + scanType + '\'' +
                ", scanTotalFileCount='" + scanTotalFileCount + '\'' +
                ", projectTotalNum='" + projectTotalNum + '\'' +
                ", clearCount='" + clearCount + '\'' +
                ", isScanAll='" + isScanAll + '\'' +
                ", isScanCompressPackge='" + isScanCompressPackge + '\'' +
                ", processType='" + processType + '\'' +
                ", isScanHardDisc='" + isScanHardDisc + '\'' +
                ", isScanRootkit='" + isScanRootkit + '\'' +
                ", isYunchaKill='" + isYunchaKill + '\'' +
                ", isRepair='" + isRepair + '\'' +
                ", conventionalEngines='" + conventionalEngines + '\'' +
                ", scanContent='" + scanContent + '\'' +
                '}';
    }
}
