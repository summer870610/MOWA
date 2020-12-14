package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.FaultType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FaultTypeMapper {
    @Delete({
        "delete from ma_faulttype",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_faulttype (Id, FaultTypeCode, ",
        "FaultType, CreateUserId, ",
        "WorkGroupId, CreatTime)",
        "values (#{id,jdbcType=INTEGER}, #{faulttypecode,jdbcType=VARCHAR}, ",
        "#{faulttype,jdbcType=VARCHAR}, #{createuserid,jdbcType=INTEGER}, ",
        "#{workgroupid,jdbcType=INTEGER}, #{creattime,jdbcType=DATE})"
    })
    int insert(FaultType record);

    @InsertProvider(type=FaultTypeSqlProvider.class, method="insertSelective")
    int insertSelective(FaultType record);

    @Select({
        "select",
        "Id, FaultTypeCode, FaultType, CreateUserId, WorkGroupId, CreatTime",
        "from ma_faulttype",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="FaultTypeCode", property="faulttypecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="FaultType", property="faulttype", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER),
        @Result(column="CreatTime", property="creattime", jdbcType=JdbcType.DATE)
    })
    FaultType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FaultTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FaultType record);

    @Update({
        "update ma_faulttype",
        "set FaultTypeCode = #{faulttypecode,jdbcType=VARCHAR},",
          "FaultType = #{faulttype,jdbcType=VARCHAR},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER},",
          "CreatTime = #{creattime,jdbcType=DATE}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FaultType record);
}