package com.zyy.mowa.dao;

public class TUsergroup {
    private Integer id;

    private String groupcode;

    private String groupname;

    private String ownerusercode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getOwnerusercode() {
        return ownerusercode;
    }

    public void setOwnerusercode(String ownerusercode) {
        this.ownerusercode = ownerusercode == null ? null : ownerusercode.trim();
    }
}