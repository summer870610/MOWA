package com.zyy.mowa.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkGroupDto {
	 private Integer id;

	    private String workgroupname;

	    private String invitecode;

	    private Integer createuserid;

	    private Date creattime;

	    private String wrokgroupdesc;

	    private Boolean ispublic;
	   
	    private String username;
}
