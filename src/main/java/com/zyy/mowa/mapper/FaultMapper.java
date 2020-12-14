package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Fault;

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

public interface FaultMapper {
    @Delete({
        "delete from ma_fault",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_fault (Id, UrgencyDegree, ",
        "FaultType, DeviceCode, ",
        "FaultDesc, Status, ",
        "CreateTime, FinishTime, ",
        "CreateUserId, WorkGroupId)",
        "values (#{id,jdbcType=INTEGER}, #{urgencydegree,jdbcType=VARCHAR}, ",
        "#{faulttype,jdbcType=VARCHAR}, #{devicecode,jdbcType=VARCHAR}, ",
        "#{faultdesc,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=DATE}, #{finishtime,jdbcType=DATE}, ",
        "#{createuserid,jdbcType=INTEGER}, #{workgroupid,jdbcType=INTEGER})"
    })
    int insert(Fault record);

    @InsertProvider(type=FaultSqlProvider.class, method="insertSelective")
    int insertSelective(Fault record);

    @Select({
        "select",
        "Id, UrgencyDegree, FaultType, DeviceCode, FaultDesc, Status, CreateTime, FinishTime, ",
        "CreateUserId, WorkGroupId",
        "from ma_fault",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UrgencyDegree", property="urgencydegree", jdbcType=JdbcType.VARCHAR),
        @Result(column="FaultType", property="faulttype", jdbcType=JdbcType.VARCHAR),
        @Result(column="DeviceCode", property="devicecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="FaultDesc", property="faultdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="Status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.DATE),
        @Result(column="FinishTime", property="finishtime", jdbcType=JdbcType.DATE),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER)
    })
    Fault selectByPrimaryKey(Integer id);
    
    @SelectProvider(type=FaultSqlProvider.class, method="selectSelective")
    List<Fault> selectSelective(Fault record);

    @UpdateProvider(type=FaultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Fault record);

    @Update({
        "update ma_fault",
        "set UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR},",
          "FaultType = #{faulttype,jdbcType=VARCHAR},",
          "DeviceCode = #{devicecode,jdbcType=VARCHAR},",
          "FaultDesc = #{faultdesc,jdbcType=VARCHAR},",
          "Status = #{status,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=DATE},",
          "FinishTime = #{finishtime,jdbcType=DATE},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Fault record);
}