package com.jh.myspringboot1.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("*******************");
        System.out.println(parameter);
        ps.setString(i,parameter);
       // System.out.println();
       // System.out.println("dddddddddddddddd");
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("aaaaaaaaaa");
        //rs.getString()
       // rs.getObject(columnName)
        return "ccdef-"+rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("bbbbbbbbbbbbbbbb");
        return "dd";
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("cccccccccccc");
        return "ee";
    }
}
