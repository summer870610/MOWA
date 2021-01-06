package com.zyy.mowa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zyy.mowa.dao.CodeTable;
import com.zyy.mowa.dao.DeviceRecord;
import com.zyy.mowa.dao.FaultTypRecord;
import com.zyy.mowa.dao.UrgencyDegreeRecord;
import com.zyy.mowa.dto.CodeKeyDto;
import com.zyy.mowa.mapper.CodeTableMapper;
import com.zyy.mowa.mapper.DeviceRecordMapper;
import com.zyy.mowa.mapper.FaultTypRecordMapper;
import com.zyy.mowa.mapper.UrgencyDegreeRecordMapper;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class CodeTableServiceImpl implements CodeTableService {
	@Autowired
	private CodeTableMapper codeTableMapper;
	@Autowired
	private UrgencyDegreeRecordMapper urgencyDegreeRecordMapper;
	@Autowired
	private DeviceRecordMapper deviceRecordMapper;
	@Autowired
	private FaultTypRecordMapper faultTypRecordMapper;

	@Override
	public List<CodeTable> getListByKey(CodeKeyDto input) {
		List<CodeTable> results = new ArrayList<CodeTable>();
		if (input.getKey().equals("Device")) {
			DeviceRecord record = new DeviceRecord();
			record.setCreateuserid(input.getUserId());
			record.setWorkgroupid(input.getWorkGroupId());
			List<DeviceRecord> records = deviceRecordMapper.selectByUser(record);
			records.stream().forEach(item -> {
				CodeTable dto = new CodeTable();
				dto.setDatacode(item.getDevicecode());
				dto.setDatakey("Device");
				dto.setDataname(item.getDevicename());
				results.add(dto);
			});
		} else {
			CodeTable codedao = new CodeTable();
			codedao.setDatakey(input.getKey());
			List<CodeTable> codes = codeTableMapper.SelectByKeySelective(codedao);
			if (codes.size() > 0) {
				results.addAll(codes);
			}
			if (input.getKey().equals("UrgencyDegree")) {
				UrgencyDegreeRecord record = new UrgencyDegreeRecord();
				record.setCreateuserid(input.getUserId());
				record.setWorkgroupid(input.getWorkGroupId());
				List<UrgencyDegreeRecord> records = urgencyDegreeRecordMapper.selectByUser(record);
				records.stream().forEach(item -> {
					CodeTable dto = new CodeTable();
					dto.setDatacode(item.getUrgencydegreecode());
					dto.setDatakey("UrgencyDegree");
					dto.setDataname(item.getUrgencydegree());
					results.add(dto);
				});
			}
			if (input.getKey().equals("FaultType")) {
				FaultTypRecord record = new FaultTypRecord();
				record.setCreateuserid(input.getUserId());
				record.setWorkgroupid(input.getWorkGroupId());
				List<FaultTypRecord> records = faultTypRecordMapper.selectByUser(record);
				
				records.stream().forEach(item -> {
					CodeTable dto = new CodeTable();
					dto.setDatacode(item.getFaulttypecode());
					dto.setDatakey("FaultType");
					dto.setDataname(item.getFaulttype());
					results.add(dto);
				});
			}
		}
		if(results.size()>6&&input.isDetail()) {
			List<CodeTable> subList = results.subList(0, 6);
			return subList;
		}else {
			return results;
		}
		

	}
	@Override
	public List<CodeTable> getCodelist(String key){
		CodeTable codedao = new CodeTable();
		codedao.setDatakey(key);
		return codeTableMapper.SelectByKeySelective(codedao);
	}

	@Override
	public int createFaultTypeRecord(FaultTypRecord record) {
	List<FaultTypRecord> list=	faultTypRecordMapper.selectByUser(record);
	if(list.size()>0) {
		list.stream().forEach(item->{
			faultTypRecordMapper.deleteByPrimaryKey(item.getId());
		});
	}
	if(record.getFaulttypecode()==null) {
	String uuidString = UUID.randomUUID().toString().replaceAll("-", "");
	record.setFaulttypecode(uuidString);
	}
	record.setCreattime(new Date());
	return faultTypRecordMapper.insertSelective(record);
	}

	@Override
	public int createDeviceRecord(DeviceRecord record) {
		List<DeviceRecord> list=	deviceRecordMapper.selectByUser(record);
		if(list.size()>0) {
			list.stream().forEach(item->{
				deviceRecordMapper.deleteByPrimaryKey(item.getId());
			});
		}
		if(record.getDevicecode()==null) {
		String uuidString = UUID.randomUUID().toString().replaceAll("-", "");
		record.setDevicecode(uuidString);
		}
		record.setCreattime(new Date());
		return deviceRecordMapper.insertSelective(record);
	}

	@Override
	public int createUrgencyDegree(UrgencyDegreeRecord record) {
		List<UrgencyDegreeRecord> list=	urgencyDegreeRecordMapper.selectByUser(record);
		if(list.size()>0) {
			list.stream().forEach(item->{
				urgencyDegreeRecordMapper.deleteByPrimaryKey(item.getId());
			});
		}
		if(record.getUrgencydegreecode()==null) {
		String uuidString = UUID.randomUUID().toString().replaceAll("-", "");
		record.setUrgencydegreecode(uuidString);
		}
		record.setCreatetime(new Date());
		return urgencyDegreeRecordMapper.insertSelective(record);
	}

	@Override
	public int deleteFaultTypeRecord(String faulttypecode) {
		return faultTypRecordMapper.deleteByCode(faulttypecode);
	}

	@Override
	public int deleteDeviceRecord(String devicecode) {
		return deviceRecordMapper.deleteByCode(devicecode);
	}

	@Override
	public int deleteUrgencyDegreeRecord(String urgencydegreecode) {
		return urgencyDegreeRecordMapper.deleteByCode(urgencydegreecode);
	}
}
