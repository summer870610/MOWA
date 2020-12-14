package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Device;

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

public interface DeviceMapper {
    @Delete({
        "delete from ma_device",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_device (Id, Pid, ",
        "DataCode, DataKey, ",
        "DataDescription, Category, ",
        "Level, WorkGroupId, ",
        "IsChileNode)",
        "values (#{id,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER}, ",
        "#{datacode,jdbcType=VARCHAR}, #{datakey,jdbcType=VARCHAR}, ",
        "#{datadescription,jdbcType=VARCHAR}, #{category,jdbcType=VARCHAR}, ",
        "#{level,jdbcType=VARCHAR}, #{workgroupid,jdbcType=INTEGER}, ",
        "#{ischilenode,jdbcType=BIT})"
    })
    int insert(Device record);

    @InsertProvider(type=DeviceSqlProvider.class, method="insertSelective")
    int insertSelective(Device record);

    @Select({
        "select",
        "Id, Pid, DataCode, DataKey, DataDescription, Category, Level, WorkGroupId, IsChileNode",
        "from ma_device",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="DataCode", property="datacode", jdbcType=JdbcType.VARCHAR),
        @Result(column="DataKey", property="datakey", jdbcType=JdbcType.VARCHAR),
        @Result(column="DataDescription", property="datadescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="Category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="Level", property="level", jdbcType=JdbcType.VARCHAR),
        @Result(column="WorkGroupId", property="workgroupid", jdbcType=JdbcType.INTEGER),
        @Result(column="IsChileNode", property="ischilenode", jdbcType=JdbcType.BIT)
    })
    Device selectByPrimaryKey(Integer id);
    
    @SelectProvider(type=DeviceSqlProvider.class, method="selectlistSelective")
  List<Device>  selectlistSelective(Device record);

    @UpdateProvider(type=DeviceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Device record);

    @Update({
        "update ma_device",
        "set Pid = #{pid,jdbcType=INTEGER},",
          "DataCode = #{datacode,jdbcType=VARCHAR},",
          "DataKey = #{datakey,jdbcType=VARCHAR},",
          "DataDescription = #{datadescription,jdbcType=VARCHAR},",
          "Category = #{category,jdbcType=VARCHAR},",
          "Level = #{level,jdbcType=VARCHAR},",
          "WorkGroupId = #{workgroupid,jdbcType=INTEGER},",
          "IsChileNode = #{ischilenode,jdbcType=BIT}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Device record);
}