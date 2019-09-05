package com.dtg.swt_monitor.buried.entity;

/**
 * @program: swt_monitor
 * @description: cpu实体
 * @author: xiaozhile
 * @create: 2019-07-10 10:34
 **/
public class CpuInfos {
    private String id;
    private String ip;
    private String errorCupRate;//CPU损坏率
    private String cpuBindCount;//cpu结合数量
    private String cpuMhz;//cpu主频
    private String useRate;//cpu使用率
    private String freeRate;//cpu空闲率
    private String cpuType;//cpu类型
    private String cpuVendor;//CPU生产商
    private String CacheSize;//缓冲存储器数量
    private String cpuSort;//cpu核数编号

    public CpuInfos(String id, String ip, String errorCupRate, String cpuBindCount, String cpuMhz, String useRate, String freeRate, String cpuType, String cpuVendor, String cacheSize, String cpuSort) {
        this.id = id;
        this.ip = ip;
        this.errorCupRate = errorCupRate;
        this.cpuBindCount = cpuBindCount;
        this.cpuMhz = cpuMhz;
        this.useRate = useRate;
        this.freeRate = freeRate;
        this.cpuType = cpuType;
        this.cpuVendor = cpuVendor;
        CacheSize = cacheSize;
        this.cpuSort = cpuSort;
    }

    public CpuInfos() {
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

    public String getErrorCupRate() {
        return errorCupRate;
    }

    public void setErrorCupRate(String errorCupRate) {
        this.errorCupRate = errorCupRate;
    }

    public String getCpuBindCount() {
        return cpuBindCount;
    }

    public void setCpuBindCount(String cpuBindCount) {
        this.cpuBindCount = cpuBindCount;
    }

    public String getCpuMhz() {
        return cpuMhz;
    }

    public void setCpuMhz(String cpuMhz) {
        this.cpuMhz = cpuMhz;
    }

    public String getUseRate() {
        return useRate;
    }

    public void setUseRate(String useRate) {
        this.useRate = useRate;
    }

    public String getFreeRate() {
        return freeRate;
    }

    public void setFreeRate(String freeRate) {
        this.freeRate = freeRate;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getCpuVendor() {
        return cpuVendor;
    }

    public void setCpuVendor(String cpuVendor) {
        this.cpuVendor = cpuVendor;
    }

    public String getCacheSize() {
        return CacheSize;
    }

    public void setCacheSize(String cacheSize) {
        CacheSize = cacheSize;
    }

    public String getCpuSort() {
        return cpuSort;
    }

    public void setCpuSort(String cpuSort) {
        this.cpuSort = cpuSort;
    }

    @Override
    public String toString() {
        return "CpuInfos{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", errorCupRate='" + errorCupRate + '\'' +
                ", cpuBindCount='" + cpuBindCount + '\'' +
                ", cpuMhz='" + cpuMhz + '\'' +
                ", useRate='" + useRate + '\'' +
                ", freeRate='" + freeRate + '\'' +
                ", cpuType='" + cpuType + '\'' +
                ", cpuVendor='" + cpuVendor + '\'' +
                ", CacheSize='" + CacheSize + '\'' +
                ", cpuSort='" + cpuSort + '\'' +
                '}';
    }
}
