package com.dtg.swt_monitor.shows.entity;

/**
 * @program: swt_monitor
 * @description: 系统日志实体
 * @author: xiaozhile
 * @create: 2019-08-22 16:29
 **/
public class SystemLogsVo {
    private int id;
    private String eventId;//事件ID
    private String eventType;//事件类型
    private String eventTime;//事件时间
    private String eventCategory;//事件类别
    private String eventSource;//事件来源
    private String eventDesc;//事件描述

    public SystemLogsVo(int id, String eventId, String eventType, String eventTime, String eventCategory, String eventSource, String eventDesc) {
        this.id = id;
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.eventCategory = eventCategory;
        this.eventSource = eventSource;
        this.eventDesc = eventDesc;
    }

    public SystemLogsVo(String eventId, String eventType, String eventTime, String eventCategory, String eventSource, String eventDesc) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.eventCategory = eventCategory;
        this.eventSource = eventSource;
        this.eventDesc = eventDesc;
    }

    public SystemLogsVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    @Override
    public String toString() {
        return "SystemLogsVo{" +
                "id=" + id +
                ", eventId='" + eventId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventCategory='" + eventCategory + '\'' +
                ", eventSource='" + eventSource + '\'' +
                ", eventDesc='" + eventDesc + '\'' +
                '}';
    }
}
