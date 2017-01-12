/**
 * Copyright 2009-2016 the original author or authors.
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

import com.jolbox.bonecp.BoneCPDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BoneCPDataSourceFactory {

    private static BoneCPDataSourceFactory boncpDataSourceFactory = null;

    private static BoneCPDataSource dataSource = null;
    //类线程锁
    private static final Class CLASS_LOCK = BoneCPDataSourceFactory.class;

    public static BoneCPDataSourceFactory getInstance() {
        if (boncpDataSourceFactory == null) {
            synchronized (CLASS_LOCK) {
                if (boncpDataSourceFactory == null) {
                    boncpDataSourceFactory = new BoneCPDataSourceFactory();
                }
            }
        }
        return boncpDataSourceFactory;
    }

    public void setProperties(Properties props) {

    }

    public BoneCPDataSourceFactory() {
    }

    public DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BoneCPDataSource();
        }
        return dataSource;
    }


    public static void main(String[] args) {


        Connection conn = null;
        try {
            long startTime = System.currentTimeMillis();
            conn = BoneCPDataSourceFactory.getInstance().getDataSource().getConnection();
            if (conn != null) {
                System.out.println("Connection successful!");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(" select * from t_role "); // do something with the connection.
                while (rs.next()) {
                    System.out.println(rs.getString(1)); // should print out "1"'
                    System.out.println(rs.getString(2)); // should print out "1"'
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("====================用时：" + (endTime - startTime) + "ms====================");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
