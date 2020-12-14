package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.VerificationCodeAndRole;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

public interface VerificationCodeAndRoleMapper {
    @Insert({
        "insert into ma_verificationcodeandrole (Id, VerificationCode, ",
        "Name, Telephone, ",
        "Position, Department, ",
        "Company, RoleId)",
        "values (#{id,jdbcType=INTEGER}, #{verificationcode,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{telephone,jdbcType=VARCHAR}, ",
        "#{position,jdbcType=VARCHAR}, #{department,jdbcType=VARCHAR}, ",
        "#{company,jdbcType=VARCHAR}, #{roleid,jdbcType=INTEGER})"
    })
    int insert(VerificationCodeAndRole record);

    @InsertProvider(type=VerificationCodeAndRoleSqlProvider.class, method="insertSelective")
    int insertSelective(VerificationCodeAndRole record);
    
    @SelectProvider(type=VerificationCodeAndRoleSqlProvider.class, method="selectSelective")
    List<VerificationCodeAndRole> selectSelective(VerificationCodeAndRole record);
}