package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.AttachmentImage;
import org.apache.ibatis.jdbc.SQL;

public class AttachmentImageSqlProvider {

    public String insertSelective(AttachmentImage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_attachmentimage");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getImageurl() != null) {
            sql.VALUES("ImageUrl", "#{imageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getImagesize() != null) {
            sql.VALUES("ImageSize", "#{imagesize,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureformat() != null) {
            sql.VALUES("PictureFormat", "#{pictureformat,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultid() != null) {
            sql.VALUES("FaultId", "#{faultid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AttachmentImage record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_attachmentimage");
        
        if (record.getImageurl() != null) {
            sql.SET("ImageUrl = #{imageurl,jdbcType=VARCHAR}");
        }
        
        if (record.getImagesize() != null) {
            sql.SET("ImageSize = #{imagesize,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureformat() != null) {
            sql.SET("PictureFormat = #{pictureformat,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultid() != null) {
            sql.SET("FaultId = #{faultid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}