/**
 * Copyright 2009-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.szh.typeHandler;

import com.szh.po.Sex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Clinton Begin
 */
public class SexEnumTypeHandler implements TypeHandler<Sex> {


    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sex.getId());
    }

    public Sex getResult(ResultSet resultSet, String s) throws SQLException {
        int id = resultSet.getInt(s);
        return Sex.getSex(id);
    }

    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(i);
        return Sex.getSex(id);
    }

    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id = callableStatement.getInt(i);
        return Sex.getSex(id);
    }
}