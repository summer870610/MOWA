package com.zyy.mowa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.Device;
import com.zyy.mowa.service.DeviceManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "设备管理")
@RestController
@RequestMapping("api/DeviceManager")
public class DeviceManagerController {
	@Autowired
	private DeviceManagerService deviceManagerService;

	@ApiOperation(value = "创建设备")
	@PostMapping("/createDevice")
	public int createDevice(Device record) {
		return deviceManagerService.createDevice(record);
	}

	@ApiOperation(value = "更新设备")
	@PostMapping("/updateDevice")
	public int updateDevice(Device record) {
		return deviceManagerService.updateDevice(record);
	}

	@ApiOperation(value = "删除设备")
	@PostMapping("/deleteDevice")
	public int deleteDevice(int id) {
		return deviceManagerService.deleteDevice(id);
	}

	@ApiOperation(value = "获取设备列表")
	@PostMapping("/getDevicelist")
	public List<Device> getDevicelist(Device record) {
		return deviceManagerService.getDevicelist(record);
	}
}
