package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.Device;

public interface DeviceManagerService {

	 int createDevice(Device record) ;
	 
	 int updateDevice(Device record);
	 
	 int deleteDevice(int id);
	 
	 List<Device> getDevicelist(Device record);
}
