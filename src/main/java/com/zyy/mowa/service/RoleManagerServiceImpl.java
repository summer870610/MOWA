package com.zyy.mowa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyy.mowa.dao.Role;
import com.zyy.mowa.dao.VerificationCodeAndRole;
import com.zyy.mowa.mapper.RoleMapper;
import com.zyy.mowa.mapper.VerificationCodeAndRoleMapper;
import com.zyy.mowa.utils.RandomCodeUtil;

@Service
public class RoleManagerServiceImpl implements RoleManagerService{
@Autowired
private VerificationCodeAndRoleMapper verificationCodeAndRoleMapper;

@Autowired
private RoleMapper  roleMapper;

@Override
public String  CreateWorkGroupAdmin(VerificationCodeAndRole input) {
	String codeString=RandomCodeUtil.getRandomCode();
	input.setVerificationcode(codeString);
	verificationCodeAndRoleMapper.insertSelective(input);
	return codeString;
	
}
@Override
public List<VerificationCodeAndRole> getCodeAndRoles(VerificationCodeAndRole input){
	return verificationCodeAndRoleMapper.selectSelective(input);
}
@Override
public int CreateRole(Role input) {
	return roleMapper.insertSelective(input);
}
@Override
public List<Role> getRoles(Role input){
	return roleMapper.selectSelective(input);
}



}
