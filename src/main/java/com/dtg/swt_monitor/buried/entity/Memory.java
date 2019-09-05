package com.dtg.swt_monitor.buried.entity;

/**
 * @program: swt_monitor
 * @description: 内存实体
 * @author: xiaozhile
 * @create: 2019-07-10 11:02
 **/
public class Memory {
    private String id;
    private String ip;
    private String totalAmount;//内存总量
    private String useAmount;//内存使用量
    private String freeAmount;//内存剩余量

    public Memory(String id, String ip, String totalAmount, String useAmount, String freeAmount) {
        this.id = id;
        this.ip = ip;
        this.totalAmount = totalAmount;
        this.useAmount = useAmount;
        this.freeAmount = freeAmount;
    }

    public Memory() {
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }

    public String getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(String freeAmount) {
        this.freeAmount = freeAmount;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", useAmount='" + useAmount + '\'' +
                ", freeAmount='" + freeAmount + '\'' +
                '}';
    }
}
