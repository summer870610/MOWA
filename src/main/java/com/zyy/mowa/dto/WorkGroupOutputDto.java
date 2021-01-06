package com.zyy.mowa.dto;

import java.util.List;

import org.apache.catalina.LifecycleListener;

import com.zyy.mowa.dao.Device;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.User;
import com.zyy.mowa.dao.WorkGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkGroupOutputDto {

	public WorkGroup group;
	public List<Fault> faultlist;
	public List<Device> devicelist;
	public List<User> userlist;
  
}
