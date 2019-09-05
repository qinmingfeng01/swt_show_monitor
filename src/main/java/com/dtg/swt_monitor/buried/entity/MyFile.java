package com.dtg.swt_monitor.buried.entity;

/**
 * @program: swt_monitor
 * @description: 文件实体
 * @author: xiaozhile
 * @create: 2019-07-10 10:57
 **/
public class MyFile {
    private String id;
    private String ip;
    private String fileType;//文件类型：目录，文件
    private String statusType;//新增，修改，删除
    private String jdPath;//文件绝对路径

    public MyFile(String id, String ip, String fileType, String statusType, String jdPath) {
        this.id = id;
        this.ip = ip;
        this.fileType = fileType;
        this.statusType = statusType;
        this.jdPath = jdPath;
    }

    public MyFile() {
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getJdPath() {
        return jdPath;
    }

    public void setJdPath(String jdPath) {
        this.jdPath = jdPath;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", fileType='" + fileType + '\'' +
                ", statusType='" + statusType + '\'' +
                ", jdPath='" + jdPath + '\'' +
                '}';
    }
}
