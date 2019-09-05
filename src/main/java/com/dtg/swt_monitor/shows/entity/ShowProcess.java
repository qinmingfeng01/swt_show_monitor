package com.dtg.swt_monitor.shows.entity;

/**
 * @program: swt_monitor
 * @description: 展示进程实体
 * @author: xiaozhile
 * @create: 2019-07-19 16:18
 **/
public class ShowProcess {
    private String processname;
    private String wctime;
    private int processsum;

    public ShowProcess(String processname, String wctime, int processsum) {
        this.processname = processname;
        this.wctime = wctime;
        this.processsum = processsum;
    }

    public ShowProcess() {
    }

    public String getProcessname() {
        return processname;
    }

    public void setProcessname(String processname) {
        this.processname = processname;
    }

    public String getWctime() {
        return wctime;
    }

    public void setWctime(String wctime) {
        this.wctime = wctime;
    }

    public double getProcesssum() {
        return processsum;
    }

    public void setProcesssum(int processsum) {
        this.processsum = processsum;
    }

    @Override
    public String toString() {
        return "ShowProcess{" +
                "processname='" + processname + '\'' +
                ", wctime='" + wctime + '\'' +
                ", processsum='" + processsum + '\'' +
                '}';
    }
}
