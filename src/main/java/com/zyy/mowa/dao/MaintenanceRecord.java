package com.zyy.mowa.dao;

import java.util.Date;

public class MaintenanceRecord {
    private Integer id;

    private Integer faultid;

    private String recorddesc;

    private Date createtime;

    private Integer createuser;

    private String updatestatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultid() {
        return faultid;
    }

    public void setFaultid(Integer faultid) {
        this.faultid = faultid;
    }

    public String getRecorddesc() {
        return recorddesc;
    }

    public void setRecorddesc(String recorddesc) {
        this.recorddesc = recorddesc == null ? null : recorddesc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public String getUpdatestatus() {
        return updatestatus;
    }

    public void setUpdatestatus(String updatestatus) {
        this.updatestatus = updatestatus == null ? null : updatestatus.trim();
    }
}