package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.FaultTypRecord;

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

public interface FaultTypRecordMapper {
    @Delete({
        "delete from ma_faulttyprecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    @Delete({
        "delete from ma_faulttyprecord",
        "where FaultTypeCode = #{faulttypecode,jdbcType=VARCHAR}"
    })
    int deleteByCode(String faulttypecode);

    @Insert({
        "insert into ma_faulttyprecord (Id, FaultTypeCode, ",
        "FaultType, CreateUserId, ",
        "WorkGroupId, CreatTime)",
        "values (#{id,jdbcType=INTEGER}, #{faulttypecode,jdbcType=VARCHAR}, ",
        "#{faulttype,jdbcType=VARCHAR}, #{createuserid,jdbcType=INTEGER}, ",
        "#{workgroupid,jdbcType=INTEGER}, #{creattime,jdbcType=TIMESTAMP})"
    })
    int insert(FaultTypRecord record);

    @InsertProvider(type=FaultTypRecordSqlProvider.class, method="insertSelective")
    int insertSelective(FaultTypRecord record);

    @Select({
        "select",
        "Id, FaultTypeCode, FaultType, CreateUserId, WorkGroupId, CreatTime",
        "from ma_faulttyprecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="FaultTypeCode", property="faulttypecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="FaultType", property="faulttype", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER),
        @Result(column="CreatTime", property="creattime", jdbcType=JdbcType.TIMESTAMP)
    })
    FaultTypRecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FaultTypRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FaultTypRecord record);

    @Update({
        "update ma_faulttyprecord",
        "set FaultTypeCode = #{faulttypecode,jdbcType=VARCHAR},",
          "FaultType = #{faulttype,jdbcType=VARCHAR},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER},",
          "CreatTime = #{creattime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FaultTypRecord record);
    
  @SelectProvider(type=FaultTypRecordSqlProvider.class, method="selectByUser")
  List<FaultTypRecord>  selectByUser(FaultTypRecord record);
}