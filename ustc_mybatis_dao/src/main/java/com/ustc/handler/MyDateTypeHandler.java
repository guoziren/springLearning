package com.ustc.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MyDateTypeHandler extends BaseTypeHandler<Date> {

    /**
     * 将java类型转换为数据库类型 varchar；
     * @param preparedStatement
     * @param i 字段位置
     * @param date java类型
     * @param type
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType type) throws SQLException {
        System.out.println("preparedStatement = " + preparedStatement + ", i = " + i + ", date = " + date + ", type = " + type);
        preparedStatement.setString(i,date.getTime()+"");
    }

    /**
     * 将数据库类型转换为java类型
     * @param resultSet
     * @param s 要转换的字段名称
     * @return
     * @throws SQLException
     */
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("resultSet = " + resultSet + ", s = " + s);
        return new Date(resultSet.getLong(s));
    }

    /**
     *
     * @param resultSet
     * @param i 字段位置
     * @return
     * @throws SQLException
     */
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("resultSet = " + resultSet + ", i = " + i);
        return new Date(resultSet.getLong(i));
    }
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}
