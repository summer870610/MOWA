package com.zyy.mowa.dao;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRecord {
    private Integer id;

    private Integer faultid;

    private String recorddesc;
   
    
    private Date createtime;

    private Integer createuser;

    private String updatestatus;
   private String username;
   private String statusdec;

   
}