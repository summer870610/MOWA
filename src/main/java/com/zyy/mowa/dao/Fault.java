package com.zyy.mowa.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fault {
    private Integer id;

    private String urgencydegree;
    private String urgencydegreename;
    private String faulttype;
    private String faulttypename;
    private String devicecode;
    private String devicename;
    private String faultdesc;
    private int imagecount;
    private String avatarurl;
    private String status;
    
  
    private String createtime;

    private Date finishtime;
    
    private Integer createuserid;
    private String username;
    private Integer workgroupid;

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 * 
	 * public String getUrgencydegree() { return urgencydegree; }
	 * 
	 * public void setUrgencydegree(String urgencydegree) { this.urgencydegree =
	 * urgencydegree == null ? null : urgencydegree.trim(); }
	 * 
	 * public String getFaulttype() { return faulttype; }
	 * 
	 * public void setFaulttype(String faulttype) { this.faulttype = faulttype ==
	 * null ? null : faulttype.trim(); }
	 * 
	 * public String getDevicecode() { return devicecode; }
	 * 
	 * public void setDevicecode(String devicecode) { this.devicecode = devicecode
	 * == null ? null : devicecode.trim(); }
	 * 
	 * public String getFaultdesc() { return faultdesc; }
	 * 
	 * public void setFaultdesc(String faultdesc) { this.faultdesc = faultdesc ==
	 * null ? null : faultdesc.trim(); }
	 * 
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status == null ? null :
	 * status.trim(); }
	 * 
	 * public Date getCreatetime() { return createtime; }
	 * 
	 * public void setCreatetime(Date createtime) { this.createtime = createtime; }
	 * 
	 * public Date getFinishtime() { return finishtime; }
	 * 
	 * public void setFinishtime(Date finishtime) { this.finishtime = finishtime; }
	 * 
	 * public Integer getCreateuserid() { return createuserid; }
	 * 
	 * public void setCreateuserid(Integer createuserid) { this.createuserid =
	 * createuserid; }
	 * 
	 * public Integer getWorkgroupid() { return workgroupid; }
	 * 
	 * public void setWorkgroupid(Integer workgroupid) { this.workgroupid =
	 * workgroupid; }
	 */
}