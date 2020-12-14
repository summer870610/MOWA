package com.zyy.mowa.service;

import java.io.IOException;

import com.zyy.mowa.dao.Role;
import com.zyy.mowa.dao.TUser;
import com.zyy.mowa.dao.User;
import com.zyy.mowa.dto.UserDto;
import com.zyy.mowa.dto.WeChatLoginDto;

public interface UserLoginService {
	UserDto loginByCode(WeChatLoginDto input) throws IOException;

	UserDto loginFrist(WeChatLoginDto input) throws IOException;

	User findUserById(Integer userid);

	Role checkUser(WeChatLoginDto input);
}
