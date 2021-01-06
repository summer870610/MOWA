package com.zyy.mowa.dto;

import java.util.List;

import com.zyy.mowa.dao.AttachmentImage;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaultDetailDto {

	public Fault fault;
	public List<AttachmentImage> images;
	public List<MaintenanceRecord> maintenanceRecords;
}
