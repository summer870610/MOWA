package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.UrgencyDegree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UrgencyDegreeMapper {
    @Delete({
        "delete from ma_urgencydegree",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_urgencydegree (Id, UrgencyDegreeCode, ",
        "UrgencyDegree, CreateUserId, ",
        "WorkGroupId, CreateTime)",
        "values (#{id,jdbcType=INTEGER}, #{urgencydegreecode,jdbcType=VARCHAR}, ",
        "#{urgencydegree,jdbcType=VARCHAR}, #{createuserid,jdbcType=INTEGER}, ",
        "#{workgroupid,jdbcType=INTEGER}, #{createtime,jdbcType=DATE})"
    })
    int insert(UrgencyDegree record);

    @InsertProvider(type=UrgencyDegreeSqlProvider.class, method="insertSelective")
    int insertSelective(UrgencyDegree record);

    @Select({
        "select",
        "Id, UrgencyDegreeCode, UrgencyDegree, CreateUserId, WorkGroupId, CreateTime",
        "from ma_urgencydegree",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UrgencyDegreeCode", property="urgencydegreecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="UrgencyDegree", property="urgencydegree", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.DATE)
    })
    UrgencyDegree selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UrgencyDegreeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UrgencyDegree record);

    @Update({
        "update ma_urgencydegree",
        "set UrgencyDegreeCode = #{urgencydegreecode,jdbcType=VARCHAR},",
          "UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER},",
          "CreateTime = #{createtime,jdbcType=DATE}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UrgencyDegree record);
}