package com.zyy.mowa.service;

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
}
