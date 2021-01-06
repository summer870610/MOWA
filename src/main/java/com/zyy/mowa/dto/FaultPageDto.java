package com.zyy.mowa.dto;

import com.zyy.mowa.dao.Fault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaultPageDto {
	private int pageNum;
	private int pageSize;
	private Fault fault;

}
