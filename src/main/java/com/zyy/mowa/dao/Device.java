package com.zyy.mowa.dao;

public class Device {
    private Integer id;

    private Integer pid;

    private String datacode;

    private String datakey;

    private String datadescription;

    private String category;

    private String level;

    private Integer workgroupid;

    private Boolean ischilenode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDatacode() {
        return datacode;
    }

    public void setDatacode(String datacode) {
        this.datacode = datacode == null ? null : datacode.trim();
    }

    public String getDatakey() {
        return datakey;
    }

    public void setDatakey(String datakey) {
        this.datakey = datakey == null ? null : datakey.trim();
    }

    public String getDatadescription() {
        return datadescription;
    }

    public void setDatadescription(String datadescription) {
        this.datadescription = datadescription == null ? null : datadescription.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getWorkgroupid() {
        return workgroupid;
    }

    public void setWorkgroupid(Integer workgroupid) {
        this.workgroupid = workgroupid;
    }

    public Boolean getIschilenode() {
        return ischilenode;
    }

    public void setIschilenode(Boolean ischilenode) {
        this.ischilenode = ischilenode;
    }
}