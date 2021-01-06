package com.zyy.mowa.dto;

import java.util.List;

import com.zyy.mowa.dao.Fault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaultListDto {

	public String month;
	public List<Fault> list;
}
