package com.kinnylee.typehandler;

import com.kinnylee.enums.UserStatus;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by lijl-c on 2018/10/24.
 */
public class EnumStatusHandler extends BaseTypeHandler<UserStatus> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, UserStatus parameter,
      JdbcType jdbcType) throws SQLException {
    ps.setInt(i, parameter.getValue());
  }

  @Override
  public UserStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
    int i = rs.getInt(columnName);

    if(rs.wasNull()){
      return null;
    }else{
      return UserStatus.getValue(i);
    }
  }

  @Override
  public UserStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    int i = rs.getInt(columnIndex);
    if(rs.wasNull()){
      return null;
    }else{
      return UserStatus.getValue(i);
    }
  }

  @Override
  public UserStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    int i = cs.getInt(columnIndex);
    if(cs.wasNull()){
      return null;
    }else{
      return UserStatus.getValue(i);
    }
  }
}
