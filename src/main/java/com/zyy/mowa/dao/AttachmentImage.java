package com.zyy.mowa.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentImage {
	private Integer id;

	private String imageurl;

	private String imagesize;

	private String pictureformat;

	private Integer faultid;
	private Integer createuserid;
	private Date createtime;

}