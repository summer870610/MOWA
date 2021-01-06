package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Device;
import org.apache.ibatis.jdbc.SQL;

public class DeviceSqlProvider {

    public String insertSelective(Device record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_device");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("Pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getDatacode() != null) {
            sql.VALUES("DataCode", "#{datacode,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakey() != null) {
            sql.VALUES("DataKey", "#{datakey,jdbcType=VARCHAR}");
        }
        
        if (record.getDatadescription() != null) {
            sql.VALUES("DataDescription", "#{datadescription,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.VALUES("Category", "#{category,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("Level", "#{level,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.VALUES("WorkGroupId", "#{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getIschilenode() != null) {
            sql.VALUES("IsChileNode", "#{ischilenode,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Device record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_device");
        
        if (record.getPid() != null) {
            sql.SET("Pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getDatacode() != null) {
            sql.SET("DataCode = #{datacode,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakey() != null) {
            sql.SET("DataKey = #{datakey,jdbcType=VARCHAR}");
        }
        
        if (record.getDatadescription() != null) {
            sql.SET("DataDescription = #{datadescription,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            sql.SET("Category = #{category,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("Level = #{level,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.SET("WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getIschilenode() != null) {
            sql.SET("IsChileNode = #{ischilenode,jdbcType=BIT}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    public String selectlistSelective(Device record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_device");
        StringBuilder condition=new StringBuilder();
        condition.append("1=1");
        if (record.getPid() != null) {
        	condition.append(" and Pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getDatacode() != null) {
        	condition.append(" and DataCode = #{datacode,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakey() != null) {
        	condition.append(" and DataKey like '%"+record.getDatakey()+"%'");
        }
        
        if (record.getDatadescription() != null) {
        	condition.append(" and DataDescription = #{datadescription,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
        	condition.append("  and Category = #{category,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
        	condition.append(" and Level = #{level,jdbcType=VARCHAR}");
        }
        
        if (record.getWorkgroupid() != null) {
        	condition.append(" and WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        if (record.getIschilenode() != null) {
        	condition.append(" and IsChileNode = #{ischilenode,jdbcType=BIT}");
        }
        
        if (record.getId() != null) {
        	condition.append(" and Id = #{id,jdbcType=INTEGER}");
        }
        
        sql.WHERE(condition.toString());
        
        return sql.toString();
    }
}