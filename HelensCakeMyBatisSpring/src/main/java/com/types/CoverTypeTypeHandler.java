package com.types;

import com.models.CoverType;
import com.mysql.cj.jdbc.CallableStatement;
import org.apache.ibatis.type.JdbcType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dreawalker on 09.08.2017.
 */
public class CoverTypeTypeHandler implements org.apache.ibatis.type.TypeHandler<CoverType> {
    public CoverType getResult(ResultSet rs, String param) throws SQLException {
        return CoverType.values()[rs.getInt(param)];
    }

    public CoverType getResult(CallableStatement cs, int col) throws SQLException {
        return CoverType.values()[cs.getInt(col)];
    }

    public void setParameter(PreparedStatement ps, int paramInt, CoverType paramType, JdbcType jdbctype)
            throws SQLException {
        ps.setInt(paramInt, paramType.ordinal());
    }

    @Override
    public CoverType getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public CoverType getResult(java.sql.CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
