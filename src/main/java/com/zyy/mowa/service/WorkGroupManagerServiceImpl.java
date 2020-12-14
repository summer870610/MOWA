package com.zyy.mowa.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyy.mowa.dao.UserAndWorkGroup;
import com.zyy.mowa.dao.WorkGroup;
import com.zyy.mowa.mapper.UserAndWorkGroupMapper;
import com.zyy.mowa.mapper.UserMapper;
import com.zyy.mowa.mapper.WorkGroupMapper;
import com.zyy.mowa.utils.RandomCodeUtil;

@Service
public class WorkGroupManagerServiceImpl implements WorkGroupManagerService {
	@Autowired
	private WorkGroupMapper workGroupMapper;
	@Autowired
	private UserAndWorkGroupMapper userAndWorkGroupMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int createWorkGroup(WorkGroup workGroup) {
	String codeString=RandomCodeUtil.getRandomCode();
	workGroup.setInvitecode(codeString);
		 workGroupMapper.insertSelective(workGroup);
		UserAndWorkGroup data =new UserAndWorkGroup();
		data.setUserid(workGroup.getCreateuserid());
		data.setWorkgroupid(workGroup.getId());
		return joinWorkGroup(data);
	}
	@Override
	public int joinWorkGroup(UserAndWorkGroup input) {
	return	userAndWorkGroupMapper.insert(input); 
		
	}
	@Override
	public int unBindUserAndWorkGroup(UserAndWorkGroup input) {
		
		return userAndWorkGroupMapper.delete(input);
	}
	@Override
	public int updateWorkGroup(WorkGroup record ) {
		return workGroupMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public WorkGroup getWorkGroup(int id) {
		return workGroupMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<WorkGroup> getWorkGroupByUserId(int userid){
		return workGroupMapper.selectByUserId(userid);
	}
	@Override
	public List<WorkGroup> getWorkGroupByCreateUserId(int userid){
		return workGroupMapper.selectByCreateUserId(userid);
	}
	
	

}
