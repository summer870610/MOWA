package com.zyy.mowa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dao.Role;
import com.zyy.mowa.dao.User;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.dto.UserDto;
import com.zyy.mowa.dto.WeChatLoginDto;
import com.zyy.mowa.service.UserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("api/UserManager")
@Api(tags = "用户管理")
public class UserManagerController {
	@Autowired
	private UserLoginService userLoginService;
	@ApiOperation(value = "通过用户Code查询用户")
	@PostMapping("/loginByCode")
	public Result<UserDto> loginByCode(@RequestBody WeChatLoginDto input) throws IOException {
		return new Result<UserDto>(userLoginService.loginByCode(input));
	}
	
	@ApiOperation(value = "通过用户Id获取用户")
	@PostMapping("/findUserById")
	public Result<UserDto> findUserById(@RequestBody Integer userid) {
		return new Result<UserDto>(userLoginService.findUserById(userid));
	}
	@ApiOperation(value = "验证管理员身份")
	@PostMapping("/checkUser")
	public Result<Role> checkUser(@RequestBody WeChatLoginDto input) {
		return new Result<Role> (userLoginService.checkUser(input));
	}
}
