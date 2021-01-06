package com.zyy.mowa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.Role;
import com.zyy.mowa.dao.VerificationCodeAndRole;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.service.RoleManagerService;
import com.zyy.mowa.utils.JwtUtils.UserLoginToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "角色管理")
@RestController
@RequestMapping("api/RoleManager")
public class RoleManagerController {
	@Autowired
	private RoleManagerService roleManagerService;

	@ApiOperation(value = "生成管理员验证码")
	@PostMapping("/CreateWorkGroupAdmin")
	public Result<String>  CreateWorkGroupAdmin(@RequestBody VerificationCodeAndRole input) {
		return new Result<String>(roleManagerService.CreateWorkGroupAdmin(input));
	}
	
	@ApiOperation(value = "获取管理员验证码列表")
	@PostMapping("/getCodeAndRoles")
	public Result<List<VerificationCodeAndRole>> getCodeAndRoles(@RequestBody VerificationCodeAndRole input){
		return new Result<List<VerificationCodeAndRole>>(roleManagerService.getCodeAndRoles(input));
	}
	
	@ApiOperation(value = "创建用户角色")
	@PostMapping("/CreateRole")
	public Result<Integer> CreateRole(@RequestBody Role input) {
		return new Result<Integer>(roleManagerService.CreateRole(input));
	}
	
	@ApiOperation(value = "获取用户角色")
	@PostMapping("/getRoles")
	public Result<List<Role>> getRoles(@RequestBody Role input){
		return new  Result<List<Role>>(roleManagerService.getRoles(input));
	}
}
