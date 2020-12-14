package com.zyy.mowa.dao;

import java.util.Date;

public class UrgencyDegree {
    private Integer id;

    private String urgencydegreecode;

    private String urgencydegree;

    private Integer createuserid;

    private Integer workgroupid;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrgencydegreecode() {
        return urgencydegreecode;
    }

    public void setUrgencydegreecode(String urgencydegreecode) {
        this.urgencydegreecode = urgencydegreecode == null ? null : urgencydegreecode.trim();
    }

    public String getUrgencydegree() {
        return urgencydegree;
    }

    public void setUrgencydegree(String urgencydegree) {
        this.urgencydegree = urgencydegree == null ? null : urgencydegree.trim();
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}