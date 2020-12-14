package com.zyy.mowa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.UserAndWorkGroup;
import com.zyy.mowa.dao.WorkGroup;
import com.zyy.mowa.service.WorkGroupManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "班组管理")
@RestController
@RequestMapping("api/WorkGroupManager")
public class WorkGroupManagerController {

	@Autowired
	private WorkGroupManagerService workGroupManagerService;
	
	@ApiOperation(value = "创建班组")
	@PostMapping("/createWorkGroup")
	public int createWorkGroup(@RequestBody WorkGroup workGroup) {
		return workGroupManagerService.createWorkGroup(workGroup);
	}
	@ApiOperation(value = "加入班组")
	@PostMapping("/joinWorkGroup")
	public int joinWorkGroup(@RequestBody UserAndWorkGroup input) {
		return workGroupManagerService.joinWorkGroup(input);
	}
	
	@ApiOperation(value = "从班组中移除")
	@PostMapping("/unBindUserAndWorkGroup")
	public int unBindUserAndWorkGroup(@RequestBody UserAndWorkGroup input) {
		return workGroupManagerService.unBindUserAndWorkGroup(input);
	}
	
	@ApiOperation(value = "修改班组信息")
	@PostMapping("/updateWorkGroup")
	public int updateWorkGroup(@RequestBody WorkGroup record ) {
		return workGroupManagerService.updateWorkGroup(record);
	}
	
	@ApiOperation(value = "通过班组Id获取班组详细信息")
	@GetMapping("/getWorkGroup")
	public WorkGroup getWorkGroup(@RequestBody int id) {
		return workGroupManagerService.getWorkGroup(id);
	}
	@ApiOperation(value = "通过用户Id获取所在班组列表")
	@GetMapping("/getWorkGroupByUserId")
	public List<WorkGroup> getWorkGroupByUserId(@RequestBody int userid){
		return workGroupManagerService.getWorkGroupByUserId(userid);
	}
	
	@ApiOperation(value = "通过用户Id获取“我创建的”班组")
	@GetMapping("/getWorkGroupByCreateUserId")
	public List<WorkGroup> getWorkGroupByCreateUserId(@RequestBody int userid){
		return workGroupManagerService.getWorkGroupByCreateUserId(userid);
	}
}
