package com.zyy.mowa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyy.mowa.dao.AttachmentImage;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;
import com.zyy.mowa.dto.FaultDetailDto;
import com.zyy.mowa.dto.FaultDto;
import com.zyy.mowa.mapper.AttachmentImageMapper;
import com.zyy.mowa.mapper.FaultMapper;
import com.zyy.mowa.mapper.MaintenanceRecordMapper;

@Service
public class FaultManagerServiceImpl implements FaultManagerService {
	@Autowired
	private FaultMapper faultMapper;
	@Autowired
	private MaintenanceRecordMapper maintenanceRecordMapper;
	
	@Autowired
	private AttachmentImageMapper attachmentImageMapper;

	@Override
	public int creatFault(FaultDto input) {
		Fault record=new Fault();
		record.setCreateuserid(input.getCreateuserid());
		record.setCreatetime(new Date().toLocaleString());
		record.setDevicecode(input.getDevicecode());
		record.setFaultdesc(input.getFaultdesc());
		record.setFaulttype(input.getFaulttype());
		record.setStatus("01");
		record.setUrgencydegree(input.getUrgencydegree());
		record.setWorkgroupid(input.getWorkgroupid());
		 faultMapper.insertSelective(record);
		 if(input.getFileIdList()!=null) {
		for (int item : input.getFileIdList()) {
			AttachmentImage file=new AttachmentImage();
			file.setFaultid(record.getId());
			file.setId(item);
			attachmentImageMapper.updateByPrimaryKeySelective(file);
		} }
		 return 1;
	}

	@Override
	public int updateFault(Fault record) {
		return faultMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int creatRecord(MaintenanceRecord record) {
		record.setCreatetime(new Date());
		 maintenanceRecordMapper.insertSelective(record);
		 Fault fault=new Fault();
		 fault.setId(record.getFaultid());
		 fault.setStatus(record.getUpdatestatus());
		 if(record.getUpdatestatus().equals("03")) {
			 fault.setFinishtime(new Date());
		 }
		return updateFault(fault);
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
	
	@Override
	public int createAttachmentImage(AttachmentImage file) {
		attachmentImageMapper.insertSelective(file);
		return file.getId();
	}
	@Override
	public int updateAttachmentImage(AttachmentImage file) {
		attachmentImageMapper.updateByPrimaryKeySelective(file);
		return file.getId();
	}
	@Override
	public FaultDetailDto getFaultDetail(Integer id) {
		FaultDetailDto result=new FaultDetailDto();
		Fault dtoFault=new Fault();
		dtoFault.setId(id);
	List<Fault> faults=faultMapper.selectSelective(dtoFault);
	if(faults.size()>0) {
	List<AttachmentImage> images=attachmentImageMapper.selectByFaultId(id);
	MaintenanceRecord record=new MaintenanceRecord();
	record.setFaultid(id);
	List<MaintenanceRecord> records=maintenanceRecordMapper.selectSelective(record);
	result.setFault(faults.get(0));
	result.setImages(images);
	result.setMaintenanceRecords(records);
	}
	return result;
	}
}
