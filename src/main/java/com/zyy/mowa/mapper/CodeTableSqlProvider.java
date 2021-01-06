package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.CodeTable;
import org.apache.ibatis.jdbc.SQL;

public class CodeTableSqlProvider {

    public String insertSelective(CodeTable record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ma_codetable");
        
        if (record.getId() != null) {
            sql.VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDatacode() != null) {
            sql.VALUES("DataCode", "#{datacode,jdbcType=VARCHAR}");
        }
        
        if (record.getDataname() != null) {
            sql.VALUES("DataName", "#{dataname,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakey() != null) {
            sql.VALUES("DataKey", "#{datakey,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakeyname() != null) {
            sql.VALUES("DataKeyName", "#{datakeyname,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CodeTable record) {
        SQL sql = new SQL();
        sql.UPDATE("ma_codetable");
        
        if (record.getDatacode() != null) {
            sql.SET("DataCode = #{datacode,jdbcType=VARCHAR}");
        }
        
        if (record.getDataname() != null) {
            sql.SET("DataName = #{dataname,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakey() != null) {
            sql.SET("DataKey = #{datakey,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakeyname() != null) {
            sql.SET("DataKeyName = #{datakeyname,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    public String SelectByKeySelective(CodeTable record) {
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("ma_codetable");
        StringBuilder conditions=new StringBuilder();
        conditions.append(" 1=1");
        if (record.getDatacode() != null) {
        	conditions.append(" and DataCode = #{datacode,jdbcType=VARCHAR}");
        }
        
        if (record.getDataname() != null) {
        	conditions.append(" and DataName = #{dataname,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakey() != null) {
        	conditions.append(" and DataKey = #{datakey,jdbcType=VARCHAR}");
        }
        
        if (record.getDatakeyname() != null) {
        	conditions.append("  and DataKeyName = #{datakeyname,jdbcType=VARCHAR}");
        }
        
        sql.WHERE(conditions.toString());
        
        return sql.toString();
    }
}