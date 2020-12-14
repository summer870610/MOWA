package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;

public interface FaultManagerService {
	public int creatFault(Fault record) ;
	
	public int updateFault(Fault record);
	
	public int creatRecord(MaintenanceRecord record);
	
	public int updateRecord(MaintenanceRecord record);
	public int deleteFault(int id);
	public int deleteRecord(int id) ;
	
	public List<Fault> selectFaults(Fault record);
	
	public List<MaintenanceRecord> getMaintenanceRecords(MaintenanceRecord record);
}
