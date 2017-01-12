package com.szh.DataSource;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zhihaosong on 16-12-12.
 */

public class BoneCPDataSourceFactory implements DataSourceFactory {
    private Properties properties = null;

    public void setProperties(Properties props) {
        this.properties = props;
    }

    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            BoneCPConfig boneCPConfig = new BoneCPConfig(properties);
            dataSource = new BoneCPDataSource(boneCPConfig);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;

    }
}
