package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Fault;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.ibatis.jdbc.SQL;

public class FaultSqlProvider {

    public String insertSelective(Fault record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_fault");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUrgencydegree() != null) {
            sql.VALUES("UrgencyDegree", "#{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
            sql.VALUES("FaultType", "#{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicecode() != null) {
            sql.VALUES("DeviceCode", "#{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultdesc() != null) {
            sql.VALUES("FaultDesc", "#{faultdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("Status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("CreateTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishtime() != null) {
            sql.VALUES("FinishTime", "#{finishtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.VALUES("CreateUserId", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.VALUES("WorkGroupId", "#{workgroupid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Fault record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_fault");
        
        if (record.getUrgencydegree() != null) {
            sql.SET("UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
            sql.SET("FaultType = #{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicecode() != null) {
            sql.SET("DeviceCode = #{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultdesc() != null) {
            sql.SET("FaultDesc = #{faultdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("Status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("CreateTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFinishtime() != null) {
            sql.SET("FinishTime = #{finishtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuserid() != null) {
            sql.SET("CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
            sql.SET("WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    
    public String selectSelective(Fault record) {
       
        StringBuilder condition=new StringBuilder();
        
        condition.append("SELECT f.*,u.Name as username,u.avatarurl, d.DeviceName,g.UrgencyDegree as urgencydegreename,t.FaultType as faulttypename,ai.imagecount from ma_fault f INNER  JOIN  ma_user u ON f.CreateUserId=u.Id " + 
        		"  INNER JOIN (SELECT r.DeviceCode,r.DeviceName,r.WorkGroupId FROM ma_devicerecord  r UNION select d.DataCode,d.DataKey,d.WorkGroupId from  ma_device d WHERE d.IsChileNode=TRUE)d ON d.DeviceCode=f.DeviceCode  " + 
        		" INNER JOIN (SELECT r.UrgencyDegreeCode,r.UrgencyDegree FROM ma_urgencydegreerecord  r UNION select d.DataCode,d.DataName from ma_codetable d WHERE d.DataKey='UrgencyDegree')    g ON g.UrgencyDegreeCode=f.UrgencyDegree " + 
        		" INNER JOIN (SELECT r.FaultTypeCode,r.FaultType FROM ma_faulttyprecord  r UNION select d.DataCode,d.DataName from ma_codetable d WHERE d.DataKey='FaultType') t ON t.FaultTypeCode=f.FaultType "
        		+ " LEFT JOIN(SELECT count(*) as imagecount,a.FaultId FROM ma_attachmentimage a GROUP BY a.FaultId ) ai on ai.FaultId=f.Id"
        		);
       
        condition.append("  where 1=1");
        if (record.getUrgencydegree() != null) {
        	condition.append(" and f.UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR}");
        }
        
        if (record.getFaulttype() != null) {
        	condition.append(" and f.FaultType = #{faulttype,jdbcType=VARCHAR}");
        }
        
        if (record.getDevicecode() != null) {
        	condition.append(" and f.DeviceCode = #{devicecode,jdbcType=VARCHAR}");
        }
        
        if (record.getFaultdesc() != null) {
        	condition.append(" and f.FaultDesc = #{faultdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
        	condition.append(" and f.Status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
        	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String[] arr=record.getCreatetime().split("-");
        	if(arr.length>0) {
        		if(!arr[0].equals("0000")){
        			condition.append("  and DATE_FORMAT(f.CreateTime,'%Y') ='"+arr[0]+"'");
        		}
        		if(!arr[1].equals("00")) {
        			condition.append("  and DATE_FORMAT(f.CreateTime,'%m') ='"+arr[1]+"'");
        		}
        	}
        	
        }
        
        if (record.getFinishtime() != null) {
        	condition.append(" and f.FinishTime = #{finishtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuserid() != null) {
        	condition.append(" and f.CreateUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getWorkgroupid() != null) {
        	condition.append(" and f.WorkGroupId = #{workgroupid,jdbcType=INTEGER}");
        }
        if (record.getId() != null) {
        	condition.append(" and f.Id = #{id,jdbcType=INTEGER}");
        }
        condition.append(" ORDER BY f.CreateTime desc");
        
        return condition.toString();
    }
}