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
            sql.VALUES("CreateTime", "#{createtime,jdbcType=TIMESTAMP}");
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
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
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
   
        StringBuilder condition=new StringBuilder();
        condition.append("SELECT m.*,u.Name as username,s.DataName as statusdec from ma_maintenancerecord m INNER JOIN ma_user u ON u.Id=m.CreateUser"
        		+ " INNER JOIN (select d.DataCode,d.DataName from ma_codetable d WHERE d.DataKey='FaultStatus') s ON s.DataCode=m.UpdateStatus");
        condition.append(" where 1=1");
        if (record.getFaultid() != null) {
        	condition.append(" and m.FaultId = #{faultid,jdbcType=INTEGER}");
        }
        
        if (record.getRecorddesc() != null) {
        	condition.append(" and m.RecordDesc = #{recorddesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
        	condition.append(" and m.CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuser() != null) {
        	condition.append("  and m.CreateUser = #{createuser,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatestatus() != null) {
        	condition.append(" and m.UpdateStatus = #{updatestatus,jdbcType=VARCHAR}");
        }
        if (record.getId() != null) {
        	condition.append(" and m.Id = #{id,jdbcType=INTEGER}");
        }
        
        
        
        return condition.toString();
    }
}