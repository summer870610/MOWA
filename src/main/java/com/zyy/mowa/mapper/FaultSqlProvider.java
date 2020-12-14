package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Fault;
import org.apache.ibatis.jdbc.SQL;

public class FaultSqlProvider {

    public String insertSelective(Fault record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_fault");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUrgencydegree() != null) {
            sql.VALUES("UrgencyDegree", "#{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
            sql.VALUES("FaultType", "#{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicecode() != null) {
            sql.VALUES("DeviceCode", "#{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultdesc() != null) {
            sql.VALUES("FaultDesc", "#{faultdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("Status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=DATE}");
        }
        
        if (record.getFinishtime() != null) {
            sql.VALUES("FinishTime", "#{finishtime,jdbcType=DATE}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.VALUES("CreateUserId", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.VALUES("WorkGroupId", "#{workgroupid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Fault record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_fault");
        
        if (record.getUrgencydegree() != null) {
            sql.SET("UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
            sql.SET("FaultType = #{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicecode() != null) {
            sql.SET("DeviceCode = #{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultdesc() != null) {
            sql.SET("FaultDesc = #{faultdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("Status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=DATE}");
        }
        
        if (record.getFinishtime() != null) {
            sql.SET("FinishTime = #{finishtime,jdbcType=DATE}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.SET("CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.SET("WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    public String selectSelective(Fault record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        
        sql.FROM("ma_fault");
        StringBuilder condition=new StringBuilder();
        condition.append("1=1");
        if (record.getUrgencydegree() != null) {
        	condition.append(" and UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
        	condition.append(" and FaultType = #{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicecode() != null) {
        	condition.append(" and DeviceCode = #{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultdesc() != null) {
        	condition.append(" and FaultDesc = #{faultdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
        	condition.append(" and Status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
        	condition.append("  and CreateTime = #{createtime,jdbcType=DATE}");
        }
        
        if (record.getFinishtime() != null) {
        	condition.append(" and FinishTime = #{finishtime,jdbcType=DATE}");
        }
        
        if (record.getCreateuserid() != null) {
        	condition.append(" and CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
        	condition.append(" and WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        if (record.getId() != null) {
        	condition.append(" and Id = #{id,jdbcType=INTEGER}");
        }
        sql.WHERE(condition.toString());
        
        return sql.toString();
    }
}