package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.UserAndWorkGroup;
import org.apache.ibatis.jdbc.SQL;

public class UserAndWorkGroupSqlProvider {

    public String insertSelective(UserAndWorkGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_userandworkgroup");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("UserId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.VALUES("WorkGroupId", "#{workgroupid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserAndWorkGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_userandworkgroup");
        
        if (record.getUserid() != null) {
            sql.SET("UserId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.SET("WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}