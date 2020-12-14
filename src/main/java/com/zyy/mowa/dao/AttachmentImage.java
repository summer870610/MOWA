package com.zyy.mowa.dao;

public class AttachmentImage {
    private Integer id;

    private String imageurl;

    private String imagesize;

    private String pictureformat;

    private Integer faultid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getImagesize() {
        return imagesize;
    }

    public void setImagesize(String imagesize) {
        this.imagesize = imagesize == null ? null : imagesize.trim();
    }

    public String getPictureformat() {
        return pictureformat;
    }

    public void setPictureformat(String pictureformat) {
        this.pictureformat = pictureformat == null ? null : pictureformat.trim();
    }

    public Integer getFaultid() {
        return faultid;
    }

    public void setFaultid(Integer faultid) {
        this.faultid = faultid;
    }
}