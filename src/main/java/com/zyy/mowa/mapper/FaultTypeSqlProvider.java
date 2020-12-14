package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.FaultType;
import org.apache.ibatis.jdbc.SQL;

public class FaultTypeSqlProvider {

    public String insertSelective(FaultType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_faulttype");
        
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
            sql.VALUES("CreatTime", "#{creattime,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FaultType record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_faulttype");
        
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
            sql.SET("CreatTime = #{creattime,jdbcType=DATE}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}