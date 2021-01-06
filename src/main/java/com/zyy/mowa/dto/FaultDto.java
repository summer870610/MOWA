package com.zyy.mowa.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaultDto {

	private Integer id;

    private String urgencydegree;

    private String faulttype;

    private String devicecode;

    private String faultdesc;

    private String status;

    private String createtime;

    private Date finishtime;

    private Integer createuserid;

    private Integer workgroupid;
    
    private List<Integer> fileIdList;
}
