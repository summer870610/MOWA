package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.Role;

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

public interface RoleMapper {
    @Delete({
        "delete from ma_role",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_role (RoleName, ",
        "IsEnable)",
        "values (#{rolename,jdbcType=VARCHAR}, ",
        "#{isenable,jdbcType=BIT})"
    })
    int insert(Role record);

    @InsertProvider(type=RoleSqlProvider.class, method="insertSelective")
    int insertSelective(Role record);

    @Select({
        "select",
        "Id, RoleName, IsEnable",
        "from ma_role",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="RoleName", property="rolename", jdbcType=JdbcType.VARCHAR),
        @Result(column="IsEnable", property="isenable", jdbcType=JdbcType.BIT)
    })
    Role selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);
    
    @SelectProvider(type=RoleSqlProvider.class, method="selectSelective")
    List<Role> selectSelective(Role record);
    
    @Update({
        "update ma_role",
        "set RoleName = #{rolename,jdbcType=VARCHAR},",
          "IsEnable = #{isenable,jdbcType=BIT}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Role record);
}