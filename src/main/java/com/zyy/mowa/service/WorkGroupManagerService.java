package com.zyy.mowa.service;

import java.util.List;

import com.zyy.mowa.dao.UserAndWorkGroup;
import com.zyy.mowa.dao.WorkGroup;
import com.zyy.mowa.utils.RandomCodeUtil;

public interface WorkGroupManagerService {

	
	public int createWorkGroup(WorkGroup workGroup);
		public int joinWorkGroup(UserAndWorkGroup input);
		public int unBindUserAndWorkGroup(UserAndWorkGroup input);
		public int updateWorkGroup(WorkGroup record ) ;
		
		public WorkGroup getWorkGroup(int id) ;
		
		public List<WorkGroup> getWorkGroupByUserId(int userid);
		public List<WorkGroup> getWorkGroupByCreateUserId(int userid);
}
