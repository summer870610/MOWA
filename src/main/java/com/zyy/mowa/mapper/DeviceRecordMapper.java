package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.DeviceRecord;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DeviceRecordMapper {
    @Delete({
        "delete from ma_devicerecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    @Delete({
        "delete from ma_devicerecord",
        "where DeviceCode = #{devicecode,jdbcType=VARCHAR}"
    })
    int deleteByCode(String  devicecode);

    @Insert({
        "insert into ma_devicerecord (Id, DeviceCode, ",
        "DeviceName, CreateUserId, ",
        "WorkGroupId, CreatTime)",
        "values (#{id,jdbcType=INTEGER}, #{devicecode,jdbcType=VARCHAR}, ",
        "#{devicename,jdbcType=VARCHAR}, #{createuserid,jdbcType=INTEGER}, ",
        "#{workgroupid,jdbcType=INTEGER}, #{creattime,jdbcType=TIMESTAMP})"
    })
    int insert(DeviceRecord record);

    @InsertProvider(type=DeviceRecordSqlProvider.class, method="insertSelective")
    int insertSelective(DeviceRecord record);

    @Select({
        "select",
        "Id, DeviceCode, DeviceName, CreateUserId, WorkGroupId, CreatTime",
        "from ma_devicerecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="DeviceCode", property="devicecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="DeviceName", property="devicename", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER),
        @Result(column="CreatTime", property="creattime", jdbcType=JdbcType.TIMESTAMP)
    })
    DeviceRecord selectByPrimaryKey(Integer id);

    @SelectProvider(type=DeviceRecordSqlProvider.class, method="selectByUser")
    List<DeviceRecord>  selectByUser(DeviceRecord record);
    @UpdateProvider(type=DeviceRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DeviceRecord record);

    @Update({
        "update ma_devicerecord",
        "set DeviceCode = #{devicecode,jdbcType=VARCHAR},",
          "DeviceName = #{devicename,jdbcType=VARCHAR},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER},",
          "CreatTime = #{creattime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DeviceRecord record);
}