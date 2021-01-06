package com.zyy.mowa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyy.mowa.dao.Device;
import com.zyy.mowa.mapper.DeviceMapper;

@Service
public class DeviceManagerServiceImpl implements DeviceManagerService{

@Autowired
private DeviceMapper deviceMapper;

@Override
 public int createDevice(Device record) {
	
	Device pDevice =deviceMapper.selectByPrimaryKey(record.getPid());
	if(pDevice!=null) {
		Device daoDevice=new Device();
		daoDevice.setPid(record.getPid());
		List<Device> devices=deviceMapper.selectlistSelective(daoDevice);
		java.text.DecimalFormat df=new java.text.DecimalFormat();
		df.applyPattern("00");
		String str= df.format(devices.size()+1);
		record.setDatacode(pDevice.getDatacode()+str);
	}else {
	   record.setDatacode("01");
	}
	
	 return deviceMapper.insertSelective(record) ;
 }
@Override
 public int updateDevice(Device record) {
	 return deviceMapper.updateByPrimaryKeySelective(record);
 }
@Override
 public int deleteDevice(int id) {
	 return deviceMapper.deleteByPrimaryKey(id);
 }
@Override
 public List<Device> getDevicelist(Device record){
	 return deviceMapper.selectlistSelective(record);
 }
@Override
public List<Device> getDevicelistForSearch(Device record){
	List<Device> result=new ArrayList<Device>();
	
	List<Device> devices=deviceMapper.selectlistSelective(record);
	devices.stream().forEach(item->{
		
		List<Device>dataDevices=findPreasent(item);
		result.addAll(dataDevices);
		
		
	});
	 return result;
}
public List<Device> findPreasent(Device record) {
	List<Device> result=new ArrayList<Device>();
		if(record.getPid()!=0) {
			result.add(record);
			Device pDevice =deviceMapper.selectByPrimaryKey(record.getPid());
			List<Device> list=findPreasent(pDevice);
			result.addAll(list);
		}else {
			result.add(record);
		}
		return result;
}
}
