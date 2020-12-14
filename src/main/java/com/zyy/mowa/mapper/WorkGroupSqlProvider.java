package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.WorkGroup;
import org.apache.ibatis.jdbc.SQL;

public class WorkGroupSqlProvider {

    public String insertSelective(WorkGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_workgroup");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupname() != null) {
            sql.VALUES("WorkGroupName", "#{workgroupname,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitecode() != null) {
            sql.VALUES("InviteCode", "#{invitecode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.VALUES("CreateUserId", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreattime() != null) {
            sql.VALUES("CreatTime", "#{creattime,jdbcType=DATE}");
        }
        
        if (record.getWrokgroupdesc() != null) {
            sql.VALUES("WrokGroupDesc", "#{wrokgroupdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIspublic() != null) {
            sql.VALUES("IsPublic", "#{ispublic,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(WorkGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_workgroup");
        
        if (record.getWorkgroupname() != null) {
            sql.SET("WorkGroupName = #{workgroupname,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitecode() != null) {
            sql.SET("InviteCode = #{invitecode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.SET("CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreattime() != null) {
            sql.SET("CreatTime = #{creattime,jdbcType=DATE}");
        }
        
        if (record.getWrokgroupdesc() != null) {
            sql.SET("WrokGroupDesc = #{wrokgroupdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIspublic() != null) {
            sql.SET("IsPublic = #{ispublic,jdbcType=BIT}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    
    
    
    
}