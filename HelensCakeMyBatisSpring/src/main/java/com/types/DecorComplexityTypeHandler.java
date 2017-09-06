package com.types;

import com.models.DecorComplexity;
import com.mysql.cj.jdbc.CallableStatement;
import org.apache.ibatis.type.JdbcType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dreawalker on 09.08.2017.
 */
public class DecorComplexityTypeHandler implements org.apache.ibatis.type.TypeHandler<DecorComplexity> {
    public DecorComplexity getResult(ResultSet rs, String param) throws SQLException {
        return DecorComplexity.values()[rs.getInt(param)];
    }

    public DecorComplexity getResult(CallableStatement cs, int col) throws SQLException {
        return DecorComplexity.values()[cs.getInt(col)];
    }

    public void setParameter(PreparedStatement ps, int paramInt, DecorComplexity paramType, JdbcType jdbctype)
            throws SQLException {
        ps.setInt(paramInt, paramType.ordinal());
    }

    @Override
    public DecorComplexity getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public DecorComplexity getResult(java.sql.CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
