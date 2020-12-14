package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.MaintenanceRecord;
import org.apache.ibatis.jdbc.SQL;

public class MaintenanceRecordSqlProvider {

    public String insertSelective(MaintenanceRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_maintenancerecord");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getFaultid() != null) {
            sql.VALUES("FaultId", "#{faultid,jdbcType=INTEGER}");
        }
        
        if (record.getRecorddesc() != null) {
            sql.VALUES("RecordDesc", "#{recorddesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=DATE}");
        }
        
        if (record.getCreateuser() != null) {
            sql.VALUES("CreateUser", "#{createuser,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatestatus() != null) {
            sql.VALUES("UpdateStatus", "#{updatestatus,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MaintenanceRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_maintenancerecord");
        
        if (record.getFaultid() != null) {
            sql.SET("FaultId = #{faultid,jdbcType=INTEGER}");
        }
        
        if (record.getRecorddesc() != null) {
            sql.SET("RecordDesc = #{recorddesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=DATE}");
        }
        
        if (record.getCreateuser() != null) {
            sql.SET("CreateUser = #{createuser,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatestatus() != null) {
            sql.SET("UpdateStatus = #{updatestatus,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    public String selectSelective(MaintenanceRecord record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_maintenancerecord");
        StringBuilder condition=new StringBuilder();
        condition.append("1=1");
        if (record.getFaultid() != null) {
        	condition.append(" and FaultId = #{faultid,jdbcType=INTEGER}");
        }
        
        if (record.getRecorddesc() != null) {
        	condition.append(" and RecordDesc = #{recorddesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
        	condition.append(" and CreateTime = #{createtime,jdbcType=DATE}");
        }
        
        if (record.getCreateuser() != null) {
        	condition.append("  and CreateUser = #{createuser,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatestatus() != null) {
        	condition.append(" and UpdateStatus = #{updatestatus,jdbcType=VARCHAR}");
        }
        if (record.getId() != null) {
        	condition.append(" and Id = #{id,jdbcType=INTEGER}");
        }
        
        sql.WHERE(condition.toString());
        
        return sql.toString();
    }
}