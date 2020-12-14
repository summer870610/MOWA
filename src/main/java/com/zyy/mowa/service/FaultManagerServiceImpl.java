package com.zyy.mowa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;
import com.zyy.mowa.mapper.FaultMapper;
import com.zyy.mowa.mapper.MaintenanceRecordMapper;

@Service
public class FaultManagerServiceImpl implements FaultManagerService {
	@Autowired
	private FaultMapper faultMapper;
	@Autowired
	private MaintenanceRecordMapper maintenanceRecordMapper;

	@Override
	public int creatFault(Fault record) {
		return faultMapper.insertSelective(record);
	}

	@Override
	public int updateFault(Fault record) {
		return faultMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int creatRecord(MaintenanceRecord record) {
		return maintenanceRecordMapper.insertSelective(record);
	}

	@Override
	public int updateRecord(MaintenanceRecord record) {
		return maintenanceRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteFault(int id) {
		return faultMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteRecord(int id) {
		return maintenanceRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Fault> selectFaults(Fault record) {
		return faultMapper.selectSelective(record);
	}

	@Override
	public List<MaintenanceRecord> getMaintenanceRecords(MaintenanceRecord record) {
		return maintenanceRecordMapper.selectSelective(record);
	}
}
