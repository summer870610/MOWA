package com.zyy.mowa.mapper;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;
import com.zyy.mowa.dao.User;
import com.zyy.mowa.dao.UserAndWorkGroup;

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

public interface UserAndWorkGroupMapper {
    @Delete({
        "delete from ma_userandworkgroup",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    @Delete({
        "delete from ma_userandworkgroup",
        "where UserId = #{userid,jdbcType=INTEGER} and WorkGroupId = #{workgroupid,jdbcType=INTEGER} "
    })
    int delete(UserAndWorkGroup record);

    @Insert({
        "insert into ma_userandworkgroup (UserId, ",
        "WorkGroupId)",
        "values ( #{userid,jdbcType=INTEGER}, ",
        "#{workgroupid,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(UserAndWorkGroup record);

    @InsertProvider(type=UserAndWorkGroupSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(UserAndWorkGroup record);

    @Select({
        "select",
        "Id, UserId, WorkGroupId",
        "from ma_userandworkgroup",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UserId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER)
    })
    UserAndWorkGroup selectByPrimaryKey(Integer id);
    @Select("select u.* from ma_userandworkgroup uw LEFT JOIN ma_user u ON uw.UserId=u.Id  where uw.WorkGroupId= #{workgroupid,jdbcType=INTEGER}")
   List<User>  SelectUserByWorkGroup(int workgroupid);

    @UpdateProvider(type=UserAndWorkGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAndWorkGroup record);

    @Update({
        "update ma_userandworkgroup",
        "set UserId = #{userid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserAndWorkGroup record);
}