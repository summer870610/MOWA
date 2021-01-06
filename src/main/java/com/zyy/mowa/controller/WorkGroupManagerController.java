package com.zyy.mowa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zyy.mowa.dao.UserAndWorkGroup;
import com.zyy.mowa.dao.WorkGroup;
import com.zyy.mowa.dto.BindWorkGroupDto;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.dto.WorkGroupOutputDto;
import com.zyy.mowa.dto.WorkPageDto;
import com.zyy.mowa.service.WorkGroupManagerService;
import com.zyy.mowa.utils.JwtUtils.UserLoginToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "班组管理")
@RestController
@RequestMapping("api/WorkGroupManager")
public class WorkGroupManagerController {

	@Autowired
	private WorkGroupManagerService workGroupManagerService;
	@UserLoginToken
	@ApiOperation(value = "创建班组")
	@PostMapping("/createWorkGroup")
	public Result<Integer> createWorkGroup(@RequestBody WorkGroup workGroup) {
		return new Result<Integer>( workGroupManagerService.createWorkGroup(workGroup));
	}
	@UserLoginToken
	@ApiOperation(value = "加入班组")
	@PostMapping("/joinWorkGroup")
	public Result<Integer> joinWorkGroup(@RequestBody BindWorkGroupDto input) {
		return new Result<Integer>(workGroupManagerService.joinWorkGroup(input));
	}
	@UserLoginToken
	@ApiOperation(value = "从班组中移除")
	@PostMapping("/unBindUserAndWorkGroup")
	public Result<Integer> unBindUserAndWorkGroup(@RequestBody UserAndWorkGroup input) {
		return new Result<Integer>(workGroupManagerService.unBindUserAndWorkGroup(input));
	}
	@UserLoginToken
	@ApiOperation(value = "修改班组信息")
	@PostMapping("/updateWorkGroup")
	public Result<Integer> updateWorkGroup(@RequestBody WorkGroup record ) {
		return new Result<Integer>( workGroupManagerService.updateWorkGroup(record));
	}
	@UserLoginToken
	@ApiOperation(value = "通过班组Id获取班组详细信息")
	@PostMapping("/getWorkGroup")
	public Result<WorkGroupOutputDto> getWorkGroup(@RequestBody int id) {
		return new  Result<WorkGroupOutputDto>(workGroupManagerService.getWorkGroup(id));
	}
	@UserLoginToken
	@ApiOperation(value = "通过用户Id获取所在班组列表")
	@PostMapping("/getWorkGroupByUserId")
	public Result<PageInfo<WorkGroupOutputDto>> getWorkGroupByUserId(@RequestBody WorkPageDto dto){
		 PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<WorkGroupOutputDto> data=workGroupManagerService.getWorkGroupByUserId(dto.getUserId());
		  PageInfo<WorkGroupOutputDto> pageInfo = new PageInfo<WorkGroupOutputDto>(data);
		return  new  Result<PageInfo<WorkGroupOutputDto>>(pageInfo);
	}
	@UserLoginToken
	@ApiOperation(value = "通过用户Id获取“我创建的”班组")
	@PostMapping("/getWorkGroupByCreateUserId")
	public Result<PageInfo<WorkGroupOutputDto>> getWorkGroupByCreateUserId(@RequestBody WorkPageDto dto){
		
		 PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
			List<WorkGroupOutputDto> data=workGroupManagerService.getWorkGroupByCreateUserId(dto.getUserId());
			  PageInfo<WorkGroupOutputDto> pageInfo = new PageInfo<WorkGroupOutputDto>(data);
			return  new  Result<PageInfo<WorkGroupOutputDto>>(pageInfo);
		
	}
}
