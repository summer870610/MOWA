package com.zyy.mowa.controller;

import java.util.List;

import javax.naming.event.NamespaceChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.CodeTable;
import com.zyy.mowa.dao.DeviceRecord;
import com.zyy.mowa.dao.FaultTypRecord;
import com.zyy.mowa.dao.UrgencyDegreeRecord;
import com.zyy.mowa.dto.CodeKeyDto;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.service.CodeTableService;
import com.zyy.mowa.utils.JwtUtils.UserLoginToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(tags = "码表管理")
@RequestMapping("api/CodeTable")
public class CodeTableController {
	@Autowired
	private CodeTableService codeTableService;

	@UserLoginToken
	@ApiOperation(value = "通过故障类型、设备、紧急程度的key获取对应的记录")
	@PostMapping("/getListByKey")
	public Result<List<CodeTable>> getListByKey(@RequestBody CodeKeyDto input) {

		List<CodeTable> data = codeTableService.getListByKey(input);
		return new Result<List<CodeTable>>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "创建故障类型记录")
	@PostMapping("/createFaultTypeRecord")
	public Result<Integer> createFaultTypeRecord(@RequestBody FaultTypRecord record) {
		int data = codeTableService.createFaultTypeRecord(record);
		return new Result<Integer>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "创建设备记录")
	@PostMapping("/createDeviceRecord")
	public Result<Integer> createDeviceRecord(@RequestBody DeviceRecord record) {
		int data = codeTableService.createDeviceRecord(record);
		return new Result<Integer>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "创建紧急程度记录")
	@PostMapping("/createUrgencyDegree")
	public Result<Integer> createUrgencyDegree(@RequestBody UrgencyDegreeRecord record) {
		int data = codeTableService.createUrgencyDegree(record);
		return new Result<Integer>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "删除故障类型记录")
	@DeleteMapping("/deleteFaultTypeRecord/{faulttypecode}")
	public Result<Integer> deleteFaultTypeRecord(@PathVariable String faulttypecode) {
		int data = codeTableService.deleteFaultTypeRecord(faulttypecode);
		return new Result<Integer>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "删除设备记录")
	@DeleteMapping("/deleteDeviceRecord/{devicecode}")
	public Result<Integer> deleteDeviceRecord(@PathVariable String devicecode) {
		int data = codeTableService.deleteDeviceRecord(devicecode);
		return new Result<Integer>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "删除紧急程度记录")
	@DeleteMapping("/deleteUrgencyDegreeRecord/{urgencydegreecode}")
	public Result<Integer> deleteUrgencyDegreeRecord(@PathVariable String urgencydegreecode) {
		int data = codeTableService.deleteUrgencyDegreeRecord(urgencydegreecode);
		return new Result<Integer>(data);
	}
	/*
	 * @UserLoginToken
	 * 
	 * @ApiOperation(value = "获取筛选条件")
	 * 
	 * @GetMapping("/getCodelist/{key}") public Result<List<CodeTable>>
	 * getCodelist(String key){ List<CodeTable> data=
	 * codeTableService.getCodelist(key); return new Result<List<CodeTable>>(data);
	 * }
	 */
}
