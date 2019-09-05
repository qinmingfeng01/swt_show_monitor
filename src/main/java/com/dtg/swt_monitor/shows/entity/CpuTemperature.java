package com.dtg.swt_monitor.shows.entity;

/**
 * @program: test002
 * @description: CPU温度测试
 * @author: xiaozhile
 * @create: 2019-08-14 16:18
 **/
public class CpuTemperature {

    //主板 °C中央处理器(CPU) °CCPU Package °CCPU IA Cores °CCPU GT Cores °C #1 CPU 核心 °C #2 CPU 核心 °C #3 CPU 核心 °C #4 CPU 核心 °CEC1 °CEC2 °CGPU 二极管 °CHDD1 °C
    private Integer id;
    private String ip;
    private String addTime;
    private String mainBoard;//主板
    private String centralCpu;//中央处理器
    private String ccpuPackage;
    private String ccpuIaCores;
    private String ccpuGtCores;
    private String cpuOneCore;//#1 CPU 核心
    private String cpuTwoCore;//#2 CPU 核心
    private String cpuThreeCore;//#3 CPU 核心
    private String cpuFourCore;//#4 CPU 核心
    private String cec1;
    private String cec2;
    private String ccpuDiode;//CGPU 二极管
    private String chd1;

    public CpuTemperature(Integer id, String mainBoard, String centralCpu, String ccpuPackage, String ccpuIaCores, String ccpuGtCores, String cpuOneCore, String cpuTwoCore, String cpuThreeCore, String cpuFourCore, String cec1, String cec2, String ccpuDiode, String chd1) {
        this.id = id;
        this.mainBoard = mainBoard;
        this.centralCpu = centralCpu;
        this.ccpuPackage = ccpuPackage;
        this.ccpuIaCores = ccpuIaCores;
        this.ccpuGtCores = ccpuGtCores;
        this.cpuOneCore = cpuOneCore;
        this.cpuTwoCore = cpuTwoCore;
        this.cpuThreeCore = cpuThreeCore;
        this.cpuFourCore = cpuFourCore;
        this.cec1 = cec1;
        this.cec2 = cec2;
        this.ccpuDiode = ccpuDiode;
        this.chd1 = chd1;
    }

    public CpuTemperature(String ip, String addTime, String mainBoard, String centralCpu, String ccpuPackage, String ccpuIaCores, String ccpuGtCores, String cpuOneCore, String cpuTwoCore, String cpuThreeCore, String cpuFourCore, String cec1, String cec2, String ccpuDiode, String chd1) {
        this.ip = ip;
        this.addTime = addTime;
        this.mainBoard = mainBoard;
        this.centralCpu = centralCpu;
        this.ccpuPackage = ccpuPackage;
        this.ccpuIaCores = ccpuIaCores;
        this.ccpuGtCores = ccpuGtCores;
        this.cpuOneCore = cpuOneCore;
        this.cpuTwoCore = cpuTwoCore;
        this.cpuThreeCore = cpuThreeCore;
        this.cpuFourCore = cpuFourCore;
        this.cec1 = cec1;
        this.cec2 = cec2;
        this.ccpuDiode = ccpuDiode;
        this.chd1 = chd1;
    }

    public CpuTemperature() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getCentralCpu() {
        return centralCpu;
    }

    public void setCentralCpu(String centralCpu) {
        this.centralCpu = centralCpu;
    }

    public String getCcpuPackage() {
        return ccpuPackage;
    }

    public void setCcpuPackage(String ccpuPackage) {
        this.ccpuPackage = ccpuPackage;
    }

    public String getCcpuIaCores() {
        return ccpuIaCores;
    }

    public void setCcpuIaCores(String ccpuIaCores) {
        this.ccpuIaCores = ccpuIaCores;
    }

    public String getCcpuGtCores() {
        return ccpuGtCores;
    }

    public void setCcpuGtCores(String ccpuGtCores) {
        this.ccpuGtCores = ccpuGtCores;
    }

    public String getCpuOneCore() {
        return cpuOneCore;
    }

    public void setCpuOneCore(String cpuOneCore) {
        this.cpuOneCore = cpuOneCore;
    }

    public String getCpuTwoCore() {
        return cpuTwoCore;
    }

    public void setCpuTwoCore(String cpuTwoCore) {
        this.cpuTwoCore = cpuTwoCore;
    }

    public String getCpuThreeCore() {
        return cpuThreeCore;
    }

    public void setCpuThreeCore(String cpuThreeCore) {
        this.cpuThreeCore = cpuThreeCore;
    }

    public String getCpuFourCore() {
        return cpuFourCore;
    }

    public void setCpuFourCore(String cpuFourCore) {
        this.cpuFourCore = cpuFourCore;
    }

    public String getCec1() {
        return cec1;
    }

    public void setCec1(String cec1) {
        this.cec1 = cec1;
    }

    public String getCec2() {
        return cec2;
    }

    public void setCec2(String cec2) {
        this.cec2 = cec2;
    }

    public String getCcpuDiode() {
        return ccpuDiode;
    }

    public void setCcpuDiode(String ccpuDiode) {
        this.ccpuDiode = ccpuDiode;
    }

    public String getChd1() {
        return chd1;
    }

    public void setChd1(String chd1) {
        this.chd1 = chd1;
    }

    @Override
    public String toString() {
        return "CpuTemperature{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", addTime='" + addTime + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                ", centralCpu='" + centralCpu + '\'' +
                ", ccpuPackage='" + ccpuPackage + '\'' +
                ", ccpuIaCores='" + ccpuIaCores + '\'' +
                ", ccpuGtCores='" + ccpuGtCores + '\'' +
                ", cpuOneCore='" + cpuOneCore + '\'' +
                ", cpuTwoCore='" + cpuTwoCore + '\'' +
                ", cpuThreeCore='" + cpuThreeCore + '\'' +
                ", cpuFourCore='" + cpuFourCore + '\'' +
                ", cec1='" + cec1 + '\'' +
                ", cec2='" + cec2 + '\'' +
                ", ccpuDiode='" + ccpuDiode + '\'' +
                ", chd1='" + chd1 + '\'' +
                '}';
    }
}
