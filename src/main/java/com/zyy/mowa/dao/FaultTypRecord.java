package com.zyy.mowa.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FaultTypRecord {
    private Integer id;

    private String faulttypecode;

    private String faulttype;

    private Integer createuserid;

    private Integer workgroupid;
   
    private Date creattime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaulttypecode() {
        return faulttypecode;
    }

    public void setFaulttypecode(String faulttypecode) {
        this.faulttypecode = faulttypecode == null ? null : faulttypecode.trim();
    }

    public String getFaulttype() {
        return faulttype;
    }

    public void setFaulttype(String faulttype) {
        this.faulttype = faulttype == null ? null : faulttype.trim();
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Integer getWorkgroupid() {
        return workgroupid;
    }

    public void setWorkgroupid(Integer workgroupid) {
        this.workgroupid = workgroupid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}