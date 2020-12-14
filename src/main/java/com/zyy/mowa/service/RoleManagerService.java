package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.Role;
import com.zyy.mowa.dao.VerificationCodeAndRole;
import com.zyy.mowa.utils.RandomCodeUtil;

public interface RoleManagerService {

	public String  CreateWorkGroupAdmin(VerificationCodeAndRole input);

	public List<VerificationCodeAndRole> getCodeAndRoles(VerificationCodeAndRole input);
	public int CreateRole(Role input);

	public List<Role> getRoles(Role input);
}
