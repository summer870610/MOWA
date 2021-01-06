package com.zyy.mowa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.Device;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.service.DeviceManagerService;
import com.zyy.mowa.utils.JwtUtils.UserLoginToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "设备管理")
@RestController
@RequestMapping("api/DeviceManager")
public class DeviceManagerController {
	@Autowired
	private DeviceManagerService deviceManagerService;
	@UserLoginToken
	@ApiOperation(value = "创建设备")
	@PostMapping("/createDevice")
	public Result<Integer> createDevice(@RequestBody Device record) {
		return new Result<Integer>(deviceManagerService.createDevice(record));
	}
	@UserLoginToken
	@ApiOperation(value = "更新设备")
	@PostMapping("/updateDevice")
	public Result<Integer> updateDevice(@RequestBody Device record) {
		return new Result<Integer>(deviceManagerService.updateDevice(record));
	}
	@UserLoginToken
	@ApiOperation(value = "删除设备")
	@PostMapping("/deleteDevice")
	public Result<Integer> deleteDevice(@RequestBody int id) {
		return new Result<Integer>(deviceManagerService.deleteDevice(id));
	}
	@UserLoginToken
	@ApiOperation(value = "获取设备列表")
	@PostMapping("/getDevicelist")
	public Result<List<Device>> getDevicelist(@RequestBody Device record) {
		return new Result<List<Device>>(deviceManagerService.getDevicelist(record));
	}
	@UserLoginToken
	@ApiOperation(value = "模糊搜索设备列表")
	@PostMapping("/getDevicelistForSearch")
	public Result<List<Device>> getDevicelistForSearch(@RequestBody Device record) {
		return new Result<List<Device>>(deviceManagerService.getDevicelistForSearch(record));
	}
	
}
