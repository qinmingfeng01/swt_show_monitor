package com.dtg.swt_monitor.shows.entity;

/**
 * @program: test002
 * @description: 电脑信息概览
 * @author: xiaozhile
 * @create: 2019-08-14 17:49
 **/
public class SysOverview {
    /**
     * si><B>版本</B></TD><TD CLASS=si>AIDA64 v6.00.5146 Beta</TD></TR>
     cpu版本 = <TR><TD CLASS=si2><B>处理器名称</B></TD><TD CLASS=si2>QuadCore Intel Core i5-6500, 3300 MHz (33 x 100)</TD></TR>
     cpu版本 = <TR><TD CLASS=si><B>主板名称</B></TD><TD CLASS=si>Asus H110-Plus</TD></TR>
     cpu版本 = <TR><TD CLASS=si2><B>显示适配器</B></TD><TD CLASS=si2>KFA2 GeForce GTX 750 Ti Video Adapter</TD></TR>
     cpu版本 = <TR><TD CLASS=si><B>已开始日志</B></TD><TD CLASS=si>2019/8/14 星期三 16:07:12</TD></TR>
     */

    private Integer id;
    private String ip;
    private String version;//版本
    private String processorName;//处理器名称
    private String mainBoardName;//主板名称
    private String adapter;//适配器
    private String startTime;//开始时间

    public SysOverview(Integer id, String ip, String version, String processorName, String mainBoardName, String adapter, String startTime) {
        this.id = id;
        this.ip = ip;
        this.version = version;
        this.processorName = processorName;
        this.mainBoardName = mainBoardName;
        this.adapter = adapter;
        this.startTime = startTime;
    }

    public SysOverview(String ip, String version, String processorName, String mainBoardName, String adapter, String startTime) {
        this.ip = ip;
        this.version = version;
        this.processorName = processorName;
        this.mainBoardName = mainBoardName;
        this.adapter = adapter;
        this.startTime = startTime;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public String getMainBoardName() {
        return mainBoardName;
    }

    public void setMainBoardName(String mainBoardName) {
        this.mainBoardName = mainBoardName;
    }

    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "SysOverview{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", version='" + version + '\'' +
                ", processorName='" + processorName + '\'' +
                ", mainBoardName='" + mainBoardName + '\'' +
                ", adapter='" + adapter + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
