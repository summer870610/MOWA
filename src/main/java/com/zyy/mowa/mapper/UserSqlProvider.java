package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_user");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("NickName", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.VALUES("Telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarurl() != null) {
            sql.VALUES("AvatarUrl", "#{avatarurl,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenid() != null) {
            sql.VALUES("OpenId", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getSessionkey() != null) {
            sql.VALUES("SessionKey", "#{sessionkey,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLatestlogintime() != null) {
            sql.VALUES("LatestLoginTime", "#{latestlogintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRoleid() != null) {
            sql.VALUES("RoleId", "#{roleid,jdbcType=INTEGER}");
        }
      
        	  sql.VALUES("IsEnabled", "#{isenabled,jdbcType=BOOLEAN}");
       
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_user");
        
        if (record.getNickname() != null) {
            sql.SET("NickName = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("Telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarurl() != null) {
            sql.SET("AvatarUrl = #{avatarurl,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenid() != null) {
            sql.SET("OpenId = #{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getSessionkey() != null) {
            sql.SET("SessionKey = #{sessionkey,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLatestlogintime() != null) {
            sql.SET("LatestLoginTime = #{latestlogintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRoleid() != null) {
            sql.SET("RoleId = #{roleid,jdbcType=INTEGER}");
        }
       
        sql.SET("IsEnabled = #{isenabled,jdbcType=BOOLEAN}");
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    public String updateByOpenIdSelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_user");
        
        if (record.getNickname() != null) {
            sql.SET("NickName = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("Telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarurl() != null) {
            sql.SET("AvatarUrl = #{avatarurl,jdbcType=VARCHAR}");
        }

        if (record.getSessionkey() != null) {
            sql.SET("SessionKey = #{sessionkey,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLatestlogintime() != null) {
            sql.SET("LatestLoginTime = #{latestlogintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRoleid() != null) {
            sql.SET("RoleId = #{roleid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("OpenId = #{openid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
    
    public String selectSelective(User record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_user");
        StringBuilder conditions=new StringBuilder();
        conditions.append(" 1=1");
        if (record.getId() != null) {
        	conditions.append(" and Id = #{id,jdbcType=INTEGER}");
        }
        if (record.getOpenid() != null) {
        	conditions.append( " and OpenId = #{openid,jdbcType=VARCHAR}");
        }
       
        if (record.getNickname() != null) {
        	conditions.append(" and NickName = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
        	conditions.append(" and Name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
        	conditions.append(" and Telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarurl() != null) {
        	conditions.append(" and AvatarUrl = #{avatarurl,jdbcType=VARCHAR}");
        }
        
      
        if (record.getSessionkey() != null) {
        	conditions.append(" and SessionKey = #{sessionkey,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
        	conditions.append(" and CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLatestlogintime() != null) {
        	conditions.append(" and LatestLoginTime = #{latestlogintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRoleid() != null) {
        	conditions.append(" and RoleId = #{roleid,jdbcType=INTEGER}");
        }
        
        sql.WHERE(conditions.toString());
        
        return sql.toString();
    }
}