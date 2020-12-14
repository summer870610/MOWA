package com.zyy.mowa.dao;

import java.util.Date;

public class WorkGroup {
    private Integer id;

    private String workgroupname;

    private String invitecode;

    private Integer createuserid;

    private Date creattime;

    private String wrokgroupdesc;

    private Boolean ispublic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkgroupname() {
        return workgroupname;
    }

    public void setWorkgroupname(String workgroupname) {
        this.workgroupname = workgroupname == null ? null : workgroupname.trim();
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode == null ? null : invitecode.trim();
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getWrokgroupdesc() {
        return wrokgroupdesc;
    }

    public void setWrokgroupdesc(String wrokgroupdesc) {
        this.wrokgroupdesc = wrokgroupdesc == null ? null : wrokgroupdesc.trim();
    }

    public Boolean getIspublic() {
        return ispublic;
    }

    public void setIspublic(Boolean ispublic) {
        this.ispublic = ispublic;
    }
}