package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.DeviceRecord;
import org.apache.ibatis.jdbc.SQL;

public class DeviceRecordSqlProvider {

    public String insertSelective(DeviceRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_devicerecord");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDevicecode() != null) {
            sql.VALUES("DeviceCode", "#{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicename() != null) {
            sql.VALUES("DeviceName", "#{devicename,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.VALUES("CreateUserId", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.VALUES("WorkGroupId", "#{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreattime() != null) {
            sql.VALUES("CreatTime", "#{creattime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DeviceRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_devicerecord");
        
        if (record.getDevicecode() != null) {
            sql.SET("DeviceCode = #{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicename() != null) {
            sql.SET("DeviceName = #{devicename,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.SET("CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.SET("WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreattime() != null) {
            sql.SET("CreatTime = #{creattime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    public String selectByUser(DeviceRecord record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_devicerecord");
        StringBuilder conditions=new StringBuilder();
        conditions.append(" 1=1");
        if (record.getDevicecode() != null) {
        	conditions.append("  and DeviceCode = #{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicename() != null) {
        	conditions.append(" and DeviceName = #{devicename,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
        	conditions.append("  and CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
        	conditions.append(" and WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreattime() != null) {
        	conditions.append(" and CreatTime = #{creattime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE(conditions.toString());
        sql.ORDER_BY(" CreatTime desc");
        
        
        return sql.toString();
    }
}