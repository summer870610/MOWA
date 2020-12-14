package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Role;
import org.apache.ibatis.jdbc.SQL;

public class RoleSqlProvider {

    public String insertSelective(Role record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_role");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRolename() != null) {
            sql.VALUES("RoleName", "#{rolename,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
            sql.VALUES("IsEnable", "#{isenable,jdbcType=BIT}");
        }
        
        return sql.toString();
    }
    public String selectSelective(Role record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_role");
        StringBuilder conditions=new StringBuilder();
        conditions.append(" 1 =1");
        if (record.getRolename() != null) {
        	conditions.append(" and RoleName = #{rolename,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
        	conditions.append(" and IsEnable = #{isenable,jdbcType=BIT}");
        }
        
        sql.WHERE(conditions.toString());
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Role record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_role");
        
        if (record.getRolename() != null) {
            sql.SET("RoleName = #{rolename,jdbcType=VARCHAR}");
        }
        
        if (record.getIsenable() != null) {
            sql.SET("IsEnable = #{isenable,jdbcType=BIT}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}