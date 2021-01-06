package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.UrgencyDegreeRecord;

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

public interface UrgencyDegreeRecordMapper {
    @Delete({
        "delete from ma_urgencydegreerecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    @Delete({
        "delete from ma_urgencydegreerecord",
        "where  UrgencyDegreeCode = #{urgencydegreecode,jdbcType=VARCHAR}"
    })
    int deleteByCode(String urgencydegreecode);

    @Insert({
        "insert into ma_urgencydegreerecord (Id, UrgencyDegreeCode, ",
        "UrgencyDegree, CreateUserId, ",
        "WorkGroupId, CreateTime)",
        "values (#{id,jdbcType=INTEGER}, #{urgencydegreecode,jdbcType=VARCHAR}, ",
        "#{urgencydegree,jdbcType=VARCHAR}, #{createuserid,jdbcType=INTEGER}, ",
        "#{workgroupid,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(UrgencyDegreeRecord record);

    @InsertProvider(type=UrgencyDegreeRecordSqlProvider.class, method="insertSelective")
    int insertSelective(UrgencyDegreeRecord record);

    @Select({
        "select",
        "Id, UrgencyDegreeCode, UrgencyDegree, CreateUserId, WorkGroupId, CreateTime",
        "from ma_urgencydegreerecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="UrgencyDegreeCode", property="urgencydegreecode", jdbcType=JdbcType.VARCHAR),
        @Result(column="UrgencyDegree", property="urgencydegree", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    UrgencyDegreeRecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UrgencyDegreeRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UrgencyDegreeRecord record);

    @Update({
        "update ma_urgencydegreerecord",
        "set UrgencyDegreeCode = #{urgencydegreecode,jdbcType=VARCHAR},",
          "UrgencyDegree = #{urgencydegree,jdbcType=VARCHAR},",
          "CreateUserId = #{createuserid,jdbcType=INTEGER},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UrgencyDegreeRecord record);
  @SelectProvider(type=UrgencyDegreeRecordSqlProvider.class, method="selectByUser")
  List<UrgencyDegreeRecord>  selectByUser(UrgencyDegreeRecord record);
}