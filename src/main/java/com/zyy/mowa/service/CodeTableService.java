package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.CodeTable;
import com.zyy.mowa.dao.DeviceRecord;
import com.zyy.mowa.dao.FaultTypRecord;
import com.zyy.mowa.dao.UrgencyDegreeRecord;
import com.zyy.mowa.dto.CodeKeyDto;

public interface CodeTableService {
	public List<CodeTable> getListByKey(CodeKeyDto input);
	public int  createFaultTypeRecord(FaultTypRecord record);
	public int createDeviceRecord(DeviceRecord record);
	public int createUrgencyDegree(UrgencyDegreeRecord record);
	public int deleteFaultTypeRecord(String faulttypecode);
	public int deleteDeviceRecord(String devicecode);
	public int deleteUrgencyDegreeRecord( String urgencydegreecode);
	
	public List<CodeTable> getCodelist(String key);
}
