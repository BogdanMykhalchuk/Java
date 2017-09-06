package com.types;

import com.models.Type;
import com.mysql.cj.jdbc.CallableStatement;
import org.apache.ibatis.type.JdbcType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dreawalker on 09.08.2017.
 */
public class TypeTypeHandler implements org.apache.ibatis.type.TypeHandler<Type> {
    public Type getResult(ResultSet rs, String param) throws SQLException {
        return Type.values()[rs.getInt(param)];
    }

    public Type getResult(CallableStatement cs, int col) throws SQLException {
        return Type.values()[cs.getInt(col)];
    }

    public void setParameter(PreparedStatement ps, int paramInt, Type paramType, JdbcType jdbctype)
            throws SQLException {
        ps.setInt(paramInt, paramType.ordinal());
    }

    @Override
    public Type getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Type getResult(java.sql.CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
