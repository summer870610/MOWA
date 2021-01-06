package com.zyy.mowa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyy.mowa.dao.Device;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.User;
import com.zyy.mowa.dao.UserAndWorkGroup;
import com.zyy.mowa.dao.WorkGroup;
import com.zyy.mowa.dto.BindWorkGroupDto;
import com.zyy.mowa.dto.WorkGroupOutputDto;
import com.zyy.mowa.mapper.DeviceMapper;
import com.zyy.mowa.mapper.FaultMapper;
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

	@Autowired
	private FaultMapper faultmapper;

	@Autowired
	private DeviceMapper deviceMapper;

	@Override
	public int createWorkGroup(WorkGroup workGroup) {
		String codeString = RandomCodeUtil.getRandomCode();
		workGroup.setInvitecode(codeString);
		workGroupMapper.insertSelective(workGroup);
		UserAndWorkGroup data = new UserAndWorkGroup();
		data.setUserid(workGroup.getCreateuserid());
		data.setWorkgroupid(workGroup.getId());
		return userAndWorkGroupMapper.insert(data);
	}

	@Override
	public int joinWorkGroup(BindWorkGroupDto input) {
		WorkGroup group = workGroupMapper.SelectByCode(input.invitecode);
		UserAndWorkGroup record = new UserAndWorkGroup();
		record.setUserid(input.userid);
		record.setWorkgroupid(group.getId());
		return userAndWorkGroupMapper.insert(record);

	}

	@Override
	public int unBindUserAndWorkGroup(UserAndWorkGroup input) {

		return userAndWorkGroupMapper.delete(input);
	}

	@Override
	public int updateWorkGroup(WorkGroup record) {
		return workGroupMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public WorkGroupOutputDto getWorkGroup(int id) {
		WorkGroupOutputDto result = new WorkGroupOutputDto();
		WorkGroup workGroup= workGroupMapper.selectByPrimaryKey(id);
		Fault fault = new Fault();
		fault.setWorkgroupid(workGroup.getId());
		List<Fault> faultlist = faultmapper.selectSelective(fault);
		result.setFaultlist(faultlist);
		List<Fault> faults = faultlist.stream().filter(o->!o.getStatus().equals("03")).collect(Collectors.toList());
		workGroup.setFaultCount(faults.size());
		Device device = new Device();
		device.setWorkgroupid(workGroup.getId());
		device.setIschilenode(true);
		List<Device> devices = deviceMapper.selectlistSelective(device);
		result.setDevicelist(devices);

		List<User> users = userAndWorkGroupMapper.SelectUserByWorkGroup(workGroup.getId());
		workGroup.setUserCount(users.size());
		result.setUserlist(users);
		List<User> users2=	users.stream().filter(o->o.getId()==workGroup.getCreateuserid()).collect(Collectors.toList());
		workGroup.setUsername(users2.get(0).getName());
		result.setGroup(workGroup);
		return result;
	}

	@Override
	public List<WorkGroupOutputDto> getWorkGroupByUserId(int userid) {
		List<WorkGroupOutputDto> result = new ArrayList<WorkGroupOutputDto>();
		List<WorkGroup> workGroups = workGroupMapper.selectByUserId(userid);
		for (WorkGroup workGroup : workGroups) {
			WorkGroupOutputDto workGroupOutputDto = new WorkGroupOutputDto();
			Fault fault = new Fault();
			fault.setWorkgroupid(workGroup.getId());
			List<Fault> faultlist = faultmapper.selectSelective(fault);
			workGroupOutputDto.setFaultlist(faultlist);
			List<Fault> faults = faultlist.stream().filter(o->!o.getStatus().equals("03")).collect(Collectors.toList());
			workGroup.setFaultCount(faults.size());
			Device device = new Device();
			device.setWorkgroupid(workGroup.getId());
			device.setIschilenode(true);
			List<Device> devices = deviceMapper.selectlistSelective(device);
			workGroupOutputDto.setDevicelist(devices);

			List<User> users = userAndWorkGroupMapper.SelectUserByWorkGroup(workGroup.getId());
			workGroupOutputDto.setUserlist(users);
			workGroup.setUserCount(users.size());
			List<User> users2=	users.stream().filter(o->o.getId()==workGroup.getCreateuserid()).collect(Collectors.toList());
			workGroup.setUsername(users2.get(0).getName());
			workGroupOutputDto.setGroup(workGroup);
			result.add(workGroupOutputDto);

		}

		return result;
	}

	@Override
	public List<WorkGroupOutputDto> getWorkGroupByCreateUserId(int userid) {
		List<WorkGroupOutputDto> result = new ArrayList<WorkGroupOutputDto>();
		List<WorkGroup> workGroups = workGroupMapper.selectByCreateUserId(userid);

		for (WorkGroup workGroup : workGroups) {
			WorkGroupOutputDto workGroupOutputDto = new WorkGroupOutputDto();
			Fault fault = new Fault();
			fault.setWorkgroupid(workGroup.getId());
			fault.setCreateuserid(userid);

			List<Fault> faultlist = faultmapper.selectSelective(fault);
			workGroupOutputDto.setFaultlist(faultlist);
			
			List<Fault> faults = faultlist.stream().filter(o->!o.getStatus().equals("03")).collect(Collectors.toList());
			workGroup.setFaultCount(faults.size());
			workGroupOutputDto.setGroup(workGroup);
			Device device = new Device();
			device.setWorkgroupid(workGroup.getId());
			device.setIschilenode(true);
			List<Device> devices = deviceMapper.selectlistSelective(device);
			workGroupOutputDto.setDevicelist(devices);
			List<User> users = userAndWorkGroupMapper.SelectUserByWorkGroup(workGroup.getId());
			workGroupOutputDto.setUserlist(users);
			workGroup.setUserCount(users.size());
			List<User> users2=	users.stream().filter(o->o.getId()==workGroup.getCreateuserid()).collect(Collectors.toList());
			workGroup.setUsername(users2.get(0).getName());
			result.add(workGroupOutputDto);
		}
		return result;
	}

}
