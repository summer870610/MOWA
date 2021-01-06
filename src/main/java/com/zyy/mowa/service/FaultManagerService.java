package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.AttachmentImage;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;
import com.zyy.mowa.dto.FaultDetailDto;
import com.zyy.mowa.dto.FaultDto;

public interface FaultManagerService {
	public int creatFault(FaultDto record) ;
	
	public int updateFault(Fault record);
	
	public int creatRecord(MaintenanceRecord record);
	
	public int updateRecord(MaintenanceRecord record);
	public int deleteFault(int id);
	public int deleteRecord(int id) ;
	
	public List<Fault> selectFaults(Fault record);
	
	public List<MaintenanceRecord> getMaintenanceRecords(MaintenanceRecord record);
	
	public int createAttachmentImage(AttachmentImage file);

	public int updateAttachmentImage(AttachmentImage file);
	
	public FaultDetailDto getFaultDetail(Integer id);
}
