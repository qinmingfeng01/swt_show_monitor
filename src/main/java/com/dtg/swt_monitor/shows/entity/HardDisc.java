package com.dtg.swt_monitor.shows.entity;

/**
 * @program: swt_monitor
 * @description: 硬盘实体
 * @author: xiaozhile
 * @create: 2019-07-10 10:35
 **/
public class HardDisc {
    private String id;
    private String ip;//ip
    private String useAmount;//已经使用容量
    private String useRate;//使用率
    private String sysTypeName;//文件系统类型，比如 FAT32、NTFS
    private String totalAmount;//该盘符总容量
    private String devName;//该盘符名称
    private String freeAmount;//剩余容量
    private String createTime;

    public HardDisc(String id, String ip, String useAmount, String useRate, String sysTypeName, String totalAmount, String devName, String freeAmount, String createTime) {
        this.id = id;
        this.ip = ip;
        this.useAmount = useAmount;
        this.useRate = useRate;
        this.sysTypeName = sysTypeName;
        this.totalAmount = totalAmount;
        this.devName = devName;
        this.freeAmount = freeAmount;
        this.createTime = createTime;
    }

    public HardDisc() {
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

    public String getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }

    public String getUseRate() {
        return useRate;
    }

    public void setUseRate(String useRate) {
        this.useRate = useRate;
    }

    public String getSysTypeName() {
        return sysTypeName;
    }

    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(String freeAmount) {
        this.freeAmount = freeAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HardDisc{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", useAmount='" + useAmount + '\'' +
                ", useRate='" + useRate + '\'' +
                ", sysTypeName='" + sysTypeName + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", devName='" + devName + '\'' +
                ", freeAmount='" + freeAmount + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
