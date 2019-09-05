package com.dtg.swt_monitor.buried.entity;

/**
 * @program: swt_monitor
 * @description: 操作系统实体
 * @author: xiaozhile
 * @create: 2019-07-10 10:36
 **/
public class OprateSys {
    private String id;
    private String ip;
    private String pcName;//当前电脑的用户名称
    private String arch;//系统内核类型--基于x64架构
    private String dataModel;//操作系统位数--64位
    private String description;//系统描述
    private String vendor;//系统卖主
    private String vendorCodeName;//系统卖主名称
    private String vendorName;//操作系统名称
    private String version;//操作系统版本号

    public OprateSys(String id, String ip, String pcName, String arch, String dataModel, String description, String vendor, String vendorCodeName, String vendorName, String version) {
        this.id = id;
        this.ip = ip;
        this.pcName = pcName;
        this.arch = arch;
        this.dataModel = dataModel;
        this.description = description;
        this.vendor = vendor;
        this.vendorCodeName = vendorCodeName;
        this.vendorName = vendorName;
        this.version = version;
    }

    public OprateSys() {
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

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getDataModel() {
        return dataModel;
    }

    public void setDataModel(String dataModel) {
        this.dataModel = dataModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorCodeName() {
        return vendorCodeName;
    }

    public void setVendorCodeName(String vendorCodeName) {
        this.vendorCodeName = vendorCodeName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OprateSys{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", pcName='" + pcName + '\'' +
                ", arch='" + arch + '\'' +
                ", dataModel='" + dataModel + '\'' +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vendorCodeName='" + vendorCodeName + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
