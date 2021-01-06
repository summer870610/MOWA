package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.WorkGroup;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface WorkGroupMapper {
    @Delete({
        "delete from ma_workgroup",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_workgroup (Id, WorkGroupName, ",
        "InviteCode, CreateUserId, ",
        "CreatTime, WrokGroupDesc, ",
        "IsPublic)",
        "values (#{id,jdbcType=INTEGER}, #{workgroupname,jdbcType=VARCHAR}, ",
        "#{invitecode,jdbcType=VARCHAR}, #{createuserid,jdbcType=INTEGER}, ",
        "#{creattime,jdbcType=TIMESTAMP}, #{wrokgroupdesc,jdbcType=VARCHAR}, ",
        "#{ispublic,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(WorkGroup record);

    @InsertProvider(type=WorkGroupSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(WorkGroup record);

    @Select({
        "select",
        "Id, WorkGroupName, InviteCode, CreateUserId, CreatTime, WrokGroupDesc, IsPublic",
        "from ma_workgroup",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="WorkGroupName", property="workgroupname", jdbcType=JdbcType.VARCHAR),
        @Result(column="InviteCode", property="invitecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="CreatTime", property="creattime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="WrokGroupDesc", property="wrokgroupdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsPublic", property="ispublic", jdbcType=JdbcType.BIT)
    })
    WorkGroup selectByPrimaryKey(Integer id);
    
   @Select("select w.* from  ma_userandworkgroup  u LEFT JOIN ma_workgroup w ON w.Id=u.WorkGroupId  where u.UserId=#{userid} OR w.IsPublic")
   List<WorkGroup>  selectByUserId(Integer userid);
   
   @Select("select * from  ma_workgroup w  where w.CreateUserId=#{userid}")
   List<WorkGroup>  selectByCreateUserId(Integer userid);
   @Select("select * from ma_workgroup w where w.InviteCode=#{invitecode}")
   WorkGroup  SelectByCode(String invitecode);
    
    @UpdateProvider(type=WorkGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WorkGroup record);

    @Update({
        "update ma_workgroup",
        "set WorkGroupName = #{workgroupname,jdbcType=VARCHAR},",
          "InviteCode = #{invitecode,jdbcType=VARCHAR},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "CreatTime = #{creattime,jdbcType=TIMESTAMP},",
          "WrokGroupDesc = #{wrokgroupdesc,jdbcType=VARCHAR},",
          "IsPublic = #{ispublic,jdbcType=BIT}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WorkGroup record);
    
}