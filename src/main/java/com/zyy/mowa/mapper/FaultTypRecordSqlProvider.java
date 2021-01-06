package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.FaultTypRecord;
import org.apache.ibatis.jdbc.SQL;

public class FaultTypRecordSqlProvider {

    public String insertSelective(FaultTypRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_faulttyprecord");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getFaulttypecode() != null) {
            sql.VALUES("FaultTypeCode", "#{faulttypecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
            sql.VALUES("FaultType", "#{faulttype,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(FaultTypRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_faulttyprecord");
        
        if (record.getFaulttypecode() != null) {
            sql.SET("FaultTypeCode = #{faulttypecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
            sql.SET("FaultType = #{faulttype,jdbcType=VARCHAR}");
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
    public String selectByUser(FaultTypRecord record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_faulttyprecord");
        StringBuilder conditions=new StringBuilder();
        conditions.append(" 1=1");
        if (record.getFaulttypecode() != null) {
        	conditions.append(" and FaultTypeCode = #{faulttypecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
        	conditions.append("  and FaultType = #{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
        	conditions.append(" and CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
        	conditions.append(" and WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreattime() != null) {
        	conditions.append(" and CreatTime = #{creattime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE(conditions.toString());
        sql.ORDER_BY("CreatTime desc");
        return sql.toString();
    }
}