package com.dtg.swt_monitor.shows.entity;

/**
 * @program: swt_monitor
 * @description: 警报实体--展示用
 * @author: xiaozhile
 * @create: 2019-08-27 16:50
 **/
public class ShowAlarm {
    private String hardwareName;
    private String ip;
    private String createTime;
    private double resultData;
    private String resultDesc;

    public ShowAlarm(String hardwareName, String ip, String createTime, double resultData, String resultDesc) {
        this.hardwareName = hardwareName;
        this.ip = ip;
        this.createTime = createTime;
        this.resultData = resultData;
        this.resultDesc = resultDesc;
    }

    public ShowAlarm(String hardwareName, String ip, String createTime, double resultData) {
        this.hardwareName = hardwareName;
        this.ip = ip;
        this.createTime = createTime;
        this.resultData = resultData;
    }

    public ShowAlarm() {
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getResultData() {
        return resultData;
    }

    public void setResultData(double resultData) {
        this.resultData = resultData;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    @Override
    public String toString() {
        return "ShowAlarm{" +
                "hardwareName='" + hardwareName + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime='" + createTime + '\'' +
                ", resultData=" + resultData +
                ", resultDesc='" + resultDesc + '\'' +
                '}';
    }
}
