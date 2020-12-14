package com.zyy.mowa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;
import com.zyy.mowa.service.FaultManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "维修管理")
@RestController
@RequestMapping("api/FaultManager")
public class FaultManagerController {
	@Autowired
	private FaultManagerService faultManagerService;

	@ApiOperation(value = "创建故障信息")
	@PostMapping("/creatFault")
	public int creatFault(@RequestBody Fault record) {
		return faultManagerService.creatFault(record);
	}

	@ApiOperation(value = "修改故障信息")
	@PostMapping("/updateFault")
	public int updateFault(@RequestBody Fault record) {
		return faultManagerService.updateFault(record);
	}

	@ApiOperation(value = "创建维修记录")
	@PostMapping("/creatRecord")
	public int creatRecord(@RequestBody MaintenanceRecord record) {
		return faultManagerService.creatRecord(record);
	}

	@ApiOperation(value = "更新指定一条维修记录")
	@PostMapping("/updateRecord")
	public int updateRecord(@RequestBody MaintenanceRecord record) {
		return faultManagerService.updateRecord(record);
	}

	@ApiOperation(value = "删除故障信息")
	@PostMapping("/deleteFault")
	public int deleteFault(@RequestBody int id) {
		return faultManagerService.deleteFault(id);
	}

	@ApiOperation(value = "删除维修记录")
	@PostMapping("/deleteRecord")
	public int deleteRecord(@RequestBody int id) {
		return faultManagerService.deleteRecord(id);
	}

	@ApiOperation(value = "查询维修列表")
	@PostMapping("/selectFaults")
	public List<Fault> selectFaults(@RequestBody Fault record) {
		return faultManagerService.selectFaults(record);
	}

	@ApiOperation(value = "查询某个故障下维修记录")
	@PostMapping("/getMaintenanceRecords")
	public List<MaintenanceRecord> getMaintenanceRecords(@RequestBody MaintenanceRecord record) {
		return faultManagerService.getMaintenanceRecords(record);
	}
}
