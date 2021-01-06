package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.UrgencyDegreeRecord;
import org.apache.ibatis.jdbc.SQL;

public class UrgencyDegreeRecordSqlProvider {

    public String insertSelective(UrgencyDegreeRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_urgencydegreerecord");
        
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
            sql.VALUES("CreateTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UrgencyDegreeRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_urgencydegreerecord");
        
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
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    public String selectByUser(UrgencyDegreeRecord record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_urgencydegreerecord");
        StringBuilder conditions=new StringBuilder();
        conditions.append(" 1=1");
        if (record.getUrgencydegreecode() != null) {
        	conditions.append(" and UrgencyDegreeCode = #{urgencydegreecode,jdbcType=VARCHAR}");
        }
        
        if (record.getUrgencydegree() != null) {
        	conditions.append(" and UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
        	conditions.append(" and CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
        	conditions.append(" and WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
        	conditions.append(" and CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE(conditions.toString());
        sql.ORDER_BY("CreateTime desc");
        
        
        return sql.toString();
    }
}