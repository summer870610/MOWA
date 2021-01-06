package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.User;
import com.zyy.mowa.dto.UserDto;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from ma_user",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_user (Id, NickName, ",
        "Name, Telephone, ",
        "AvatarUrl, OpenId, ",
        "SessionKey, CreateTime, ",
        "LatestLoginTime, RoleId)",
        "values (#{id,jdbcType=INTEGER}, #{nickname,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{telephone,jdbcType=VARCHAR}, ",
        "#{avatarurl,jdbcType=VARCHAR}, #{openid,jdbcType=VARCHAR}, ",
        "#{sessionkey,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{isenabled,jdbcType=VARCHAR}, #{isenabled,jdbcType=BOOLEAN}, ",
        "#{latestlogintime,jdbcType=TIMESTAMP}, #{roleid,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(User record);

    @Select({
        "SELECT  u.Id,u.Name,u.NickName,u.AvatarUrl,u.SessionKey,u.Telephone,u.IsEnabled,r.RoleName,v.Company,v.Department, v.Position FROM ma_user u LEFT JOIN  ma_role r ON u.RoleId=r.Id LEFT JOIN ma_verificationcodeandrole v ON u.RoleId=v.RoleId ",
        "where u.Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NickName", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="Telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="AvatarUrl", property="avatarurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="AvatarUrl", property="avatarurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="RoleName", property="rolename", jdbcType=JdbcType.INTEGER)
    })
    UserDto selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update ma_user",
        "set NickName = #{nickname,jdbcType=VARCHAR},",
          "Name = #{name,jdbcType=VARCHAR},",
          "Telephone = #{telephone,jdbcType=VARCHAR},",
          "AvatarUrl = #{avatarurl,jdbcType=VARCHAR},",
          "OpenId = #{openid,jdbcType=VARCHAR},",
          "SessionKey = #{sessionkey,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "LatestLoginTime = #{latestlogintime,jdbcType=TIMESTAMP},",
          "RoleId = #{roleid,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
  @UpdateProvider(type = UserSqlProvider.class,method = "updateByOpenIdSelective")
  int  updateByOpenIdSelective(User record);
    
  @SelectProvider(type = UserSqlProvider.class,method = "selectSelective")
  List<User>  selectSelective(User record);
}