package com.zyy.mowa.dao;

public class CodeTable {
    private Integer id;

    private String datacode;

    private String dataname;

    private String datakey;

    private String datakeyname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatacode() {
        return datacode;
    }

    public void setDatacode(String datacode) {
        this.datacode = datacode == null ? null : datacode.trim();
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname == null ? null : dataname.trim();
    }

    public String getDatakey() {
        return datakey;
    }

    public void setDatakey(String datakey) {
        this.datakey = datakey == null ? null : datakey.trim();
    }

    public String getDatakeyname() {
        return datakeyname;
    }

    public void setDatakeyname(String datakeyname) {
        this.datakeyname = datakeyname == null ? null : datakeyname.trim();
    }
}