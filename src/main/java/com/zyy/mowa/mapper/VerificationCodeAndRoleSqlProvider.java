package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.VerificationCodeAndRole;
import org.apache.ibatis.jdbc.SQL;

public class VerificationCodeAndRoleSqlProvider {

    public String insertSelective(VerificationCodeAndRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_verificationcodeandrole");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVerificationcode() != null) {
            sql.VALUES("VerificationCode", "#{verificationcode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.VALUES("Telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getPosition() != null) {
            sql.VALUES("Position", "#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            sql.VALUES("Department", "#{department,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            sql.VALUES("Company", "#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleid() != null) {
            sql.VALUES("RoleId", "#{roleid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
    public String selectSelective(VerificationCodeAndRole record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_verificationcodeandrole");
        StringBuilder conditions=new StringBuilder();
        conditions.append("1=1");
        if (record.getId() != null) {
        	conditions.append(" and Id=#{id,jdbcType=INTEGER}");
        }
        
        if (record.getVerificationcode() != null) {
        	conditions.append(" and VerificationCode=#{verificationcode,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
        	conditions.append(" and Name=#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
        	conditions.append(" and Telephone=#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getPosition() != null) {
        	conditions.append(" and Position=#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
        	conditions.append(" and Department=#{department,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
        	conditions.append(" and Company=#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleid() != null) {
        	conditions.append(" and RoleId=#{roleid,jdbcType=INTEGER}");
        }
        sql.WHERE(conditions.toString());
        
        return sql.toString();
    }
}