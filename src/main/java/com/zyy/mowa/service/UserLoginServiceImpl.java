package com.zyy.mowa.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zyy.mowa.dao.Role;
import com.zyy.mowa.dao.TUser;
import com.zyy.mowa.dao.User;
import com.zyy.mowa.dao.VerificationCodeAndRole;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.dto.UserDto;
import com.zyy.mowa.dto.WeChartResultDto;
import com.zyy.mowa.dto.WeChatLoginDto;
import com.zyy.mowa.mapper.RoleMapper;
import com.zyy.mowa.mapper.UserMapper;
import com.zyy.mowa.mapper.VerificationCodeAndRoleMapper;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private VerificationCodeAndRoleMapper verificationCodeAndRoleMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserDto loginByCode(WeChatLoginDto input) throws IOException {

		WeChartResultDto dto = getWechat(input);
		User record = new User();
		record.setOpenid(dto.getOpenid());

		List<User> list = userMapper.selectSelective(record);
		if (list.size() > 0) {
			record.setId(list.get(0).getId());
			record.setSessionkey(dto.getSession_key());
			if (input.getAvatarurl() != null) {
				record.setAvatarurl(input.getAvatarurl());
			}
			if (input.getNickname() != null) {
				record.setNickname(input.getNickname());
			}
			record.setLatestlogintime(new Date());
			userMapper.updateByPrimaryKeySelective(list.get(0));
		}
		UserDto data = new UserDto();
		data.setId(record.getId());
		data.setUsername(record.getName());
		data.setNickname(record.getNickname());
		data.setAvatarurl(record.getAvatarurl());
		data.setSessionkey(record.getSessionkey());

		return data;
	}

	@Override
	public UserDto loginFrist(WeChatLoginDto input) throws IOException {

		WeChartResultDto dto = new WeChartResultDto();
		dto = getWechat(input);

		User record = new User();
		record.setOpenid(dto.getOpenid());
		record.setSessionkey(dto.getSession_key());
		if (input.getVerificationcode() != null) {
			int roleid = getRoleBVerificationCode(input);
			record.setRoleid(roleid);
		}
		if (input.getAvatarurl() != null) {
			record.setAvatarurl(input.getAvatarurl());
		}
		if (input.getNickname() != null) {
			record.setNickname(input.getNickname());
		}
		record.setName(input.getUsername());
		record.setTelephone(input.getTelephone());
		record.setLatestlogintime(new Date());
		int i = userMapper.insertSelective(record);
		UserDto data = new UserDto();
		data.setId(record.getId());
		data.setUsername(record.getName());
		data.setNickname(record.getNickname());
		data.setAvatarurl(record.getAvatarurl());
		data.setSessionkey(record.getSessionkey());
		return data;

	}

	@Override
	public Role checkUser(WeChatLoginDto input) {
		int roleid = getRoleBVerificationCode(input);
		User recordUser = new User();
		recordUser.setId(input.getUserId());
		recordUser.setRoleid(roleid);
		userMapper.updateByPrimaryKeySelective(recordUser);
		Role role = roleMapper.selectByPrimaryKey(roleid);
		return role;
	}

	private Integer getRoleBVerificationCode(WeChatLoginDto input) {
		VerificationCodeAndRole record = new VerificationCodeAndRole();
		record.setVerificationcode(input.getVerificationcode());
		record.setName(input.getUsername());
		record.setTelephone(input.getTelephone());
		List<VerificationCodeAndRole> dataAndRoles = verificationCodeAndRoleMapper.selectSelective(record);
		if (dataAndRoles.size() > 0) {
			return dataAndRoles.get(0).getRoleid();
		} else {
			return null;
		}
	}

	private WeChartResultDto getWechat(WeChatLoginDto input) throws IOException {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
		String str = String.format(url, "wx2d987b8416525434", "69ce321534f6ba8c22750fa2a13e7d97", input.getUsercode());
		URL serverUrl = new URL(str);
		HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.connect();

		String result = getReturn(conn);
		WeChartResultDto dto = JSON.parseObject(result, WeChartResultDto.class);
		return dto;
	}

	@Override
	public User findUserById(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

	public static String getReturn(HttpURLConnection connection) throws IOException {
		StringBuffer buffer = new StringBuffer();
		// 将返回的输入流转换成字符串
		try (InputStream inputStream = connection.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			String result = buffer.toString();
			return result;
		}
	}
}
