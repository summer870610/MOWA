package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.CodeTable;

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

public interface CodeTableMapper {
    @Delete({
        "delete from ma_codetable",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_codetable (Id, DataCode, ",
        "DataName, DataKey, ",
        "DataKeyName)",
        "values (#{id,jdbcType=INTEGER}, #{datacode,jdbcType=VARCHAR}, ",
        "#{dataname,jdbcType=VARCHAR}, #{datakey,jdbcType=VARCHAR}, ",
        "#{datakeyname,jdbcType=VARCHAR})"
    })
    int insert(CodeTable record);

    @InsertProvider(type=CodeTableSqlProvider.class, method="insertSelective")
    int insertSelective(CodeTable record);

    @Select({
        "select",
        "Id, DataCode, DataName, DataKey, DataKeyName",
        "from ma_codetable",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="DataCode", property="datacode", jdbcType=JdbcType.VARCHAR),
        @Result(column="DataName", property="dataname", jdbcType=JdbcType.VARCHAR),
        @Result(column="DataKey", property="datakey", jdbcType=JdbcType.VARCHAR),
        @Result(column="DataKeyName", property="datakeyname", jdbcType=JdbcType.VARCHAR)
    })
    CodeTable selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CodeTableSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CodeTable record);

    @Update({
        "update ma_codetable",
        "set DataCode = #{datacode,jdbcType=VARCHAR},",
          "DataName = #{dataname,jdbcType=VARCHAR},",
          "DataKey = #{datakey,jdbcType=VARCHAR},",
          "DataKeyName = #{datakeyname,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CodeTable record);
    
    @SelectProvider(type=CodeTableSqlProvider.class, method="SelectByKeySelective")
  List<CodeTable>  SelectByKeySelective(CodeTable record);
}