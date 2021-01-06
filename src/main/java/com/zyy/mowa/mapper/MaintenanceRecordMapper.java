package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.MaintenanceRecord;

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

public interface MaintenanceRecordMapper {
    @Delete({
        "delete from ma_maintenancerecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_maintenancerecord (Id, FaultId, ",
        "RecordDesc, CreateTime, ",
        "CreateUser, UpdateStatus)",
        "values (#{id,jdbcType=INTEGER}, #{faultid,jdbcType=INTEGER}, ",
        "#{recorddesc,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{createuser,jdbcType=INTEGER}, #{updatestatus,jdbcType=VARCHAR})"
    })
    int insert(MaintenanceRecord record);

    @InsertProvider(type=MaintenanceRecordSqlProvider.class, method="insertSelective")
    int insertSelective(MaintenanceRecord record);

    @Select({
        "select",
        "Id, FaultId, RecordDesc, CreateTime, CreateUser, UpdateStatus",
        "from ma_maintenancerecord",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="FaultId", property="faultid", jdbcType=JdbcType.INTEGER),
        @Result(column="RecordDesc", property="recorddesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CreateUser", property="createuser", jdbcType=JdbcType.INTEGER),
        @Result(column="UpdateStatus", property="updatestatus", jdbcType=JdbcType.VARCHAR)
    })
    MaintenanceRecord selectByPrimaryKey(Integer id);
    
    @SelectProvider(type=MaintenanceRecordSqlProvider.class, method="selectSelective")
  List<MaintenanceRecord>  selectSelective(MaintenanceRecord record);

    @UpdateProvider(type=MaintenanceRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MaintenanceRecord record);

    @Update({
        "update ma_maintenancerecord",
        "set FaultId = #{faultid,jdbcType=INTEGER},",
          "RecordDesc = #{recorddesc,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "CreateUser = #{createuser,jdbcType=INTEGER},",
          "UpdateStatus = #{updatestatus,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MaintenanceRecord record);
}