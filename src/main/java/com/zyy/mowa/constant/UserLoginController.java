package com.zyy.mowa.constant;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyy.mowa.dto.Result;
import com.zyy.mowa.dto.UserDto;
import com.zyy.mowa.dto.WeChatLoginDto;
import com.zyy.mowa.service.UserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "微信小程序登录")
@RestController
@RequestMapping("api/UserLogin")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	@ApiOperation(value = "非首次登录")
	@PostMapping("/loginByCode")
	public Result<UserDto>  loginByCode(@RequestBody WeChatLoginDto input) throws IOException{
	UserDto data=	userLoginService.loginByCode(input);
		return new Result<UserDto>(data);
	}
	@ApiOperation(value = "首次登录")
	@PostMapping("/loginFrist")
	public Result<UserDto> loginFrist(@RequestBody WeChatLoginDto input) throws IOException{
		UserDto data=	userLoginService.loginFrist(input);
		return new Result<UserDto>(data);
	}
}
