package com.dtg.swt_monitor.buried.entity;

import java.util.List;

/**
 * @program: swt_monitor
 * @description: 进程实体
 * @author: xiaozhile
 * @create: 2019-07-10 10:33
 **/
public class ComputerProcess {
    private String id;
    private String pid;
    private String userName;//用户名
    private String sTime;//该进程开启时间
    private String programsize;//进程大小
    private String memorySize;//进程使用大小
    private String share;//进程占有者
    private String state;//进程状态
    private String time;//进程持续时间
    private String cpuRate;//cpu使用率
    private String processName;//进程名称及所在位置
    private String ip;
    private String createtime;

    public ComputerProcess(String id, String pid, String userName, String sTime, String programsize, String memorySize, String share, String state, String time, String cpuRate, String processName, String ip, String createtime) {
        this.id = id;
        this.pid = pid;
        this.userName = userName;
        this.sTime = sTime;
        this.programsize = programsize;
        this.memorySize = memorySize;
        this.share = share;
        this.state = state;
        this.time = time;
        this.cpuRate = cpuRate;
        this.processName = processName;
        this.ip = ip;
        this.createtime = createtime;
    }

    public ComputerProcess() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getProgramsize() {
        return programsize;
    }

    public void setProgramsize(String programsize) {
        this.programsize = programsize;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCpuRate() {
        return cpuRate;
    }

    public void setCpuRate(String cpuRate) {
        this.cpuRate = cpuRate;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void fuZhi(List<String> list){
        this.setPid(list.get(0));
        this.setUserName(list.get(1));
        this.setsTime(list.get(2));
        this.setProgramsize(list.get(3));
        this.setMemorySize(list.get(4));
        this.setShare(list.get(5));
        this.setState(list.get(6));
        this.setTime(list.get(7));
        this.setCpuRate(list.get(8));
        this.setProcessName(list.get(9).replace("\\", "/"));
    }

    @Override
    public String toString() {
        return "ComputerProcess{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", userName='" + userName + '\'' +
                ", sTime='" + sTime + '\'' +
                ", programsize='" + programsize + '\'' +
                ", memorySize='" + memorySize + '\'' +
                ", share='" + share + '\'' +
                ", state='" + state + '\'' +
                ", time='" + time + '\'' +
                ", cpuRate='" + cpuRate + '\'' +
                ", processName='" + processName + '\'' +
                ", ip='" + ip + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
