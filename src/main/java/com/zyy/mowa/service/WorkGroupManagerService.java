package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.UserAndWorkGroup;
import com.zyy.mowa.dao.WorkGroup;
import com.zyy.mowa.dto.BindWorkGroupDto;
import com.zyy.mowa.dto.WorkGroupOutputDto;
import com.zyy.mowa.utils.RandomCodeUtil;

public interface WorkGroupManagerService {

	
	public int createWorkGroup(WorkGroup workGroup);
		public int joinWorkGroup(BindWorkGroupDto input);
		public int unBindUserAndWorkGroup(UserAndWorkGroup input);
		public int updateWorkGroup(WorkGroup record ) ;
		
		public WorkGroupOutputDto getWorkGroup(int id) ;
		
		public List<WorkGroupOutputDto> getWorkGroupByUserId(int userid);
		public List<WorkGroupOutputDto> getWorkGroupByCreateUserId(int userid);
}
