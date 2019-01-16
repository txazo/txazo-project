package org.txazo.project.mini.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSourceFactory implements DataSourceFactory {

    private DataSource dataSource;

    public DruidDataSourceFactory(Properties props) {
        try {
            dataSource = com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

}
