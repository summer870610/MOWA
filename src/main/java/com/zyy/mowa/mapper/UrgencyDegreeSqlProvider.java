package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.UrgencyDegree;
import org.apache.ibatis.jdbc.SQL;

public class UrgencyDegreeSqlProvider {

    public String insertSelective(UrgencyDegree record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_urgencydegree");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUrgencydegreecode() != null) {
            sql.VALUES("UrgencyDegreeCode", "#{urgencydegreecode,jdbcType=VARCHAR}");
        }
        
        if (record.getUrgencydegree() != null) {
            sql.VALUES("UrgencyDegree", "#{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.VALUES("CreateUserId", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.VALUES("WorkGroupId", "#{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UrgencyDegree record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_urgencydegree");
        
        if (record.getUrgencydegreecode() != null) {
            sql.SET("UrgencyDegreeCode = #{urgencydegreecode,jdbcType=VARCHAR}");
        }
        
        if (record.getUrgencydegree() != null) {
            sql.SET("UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.SET("CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.SET("WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=DATE}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}