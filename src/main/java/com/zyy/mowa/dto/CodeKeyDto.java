package com.zyy.mowa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeKeyDto {
	private String key;
	private int userId;
	private int workGroupId;
	private boolean isDetail;
}
