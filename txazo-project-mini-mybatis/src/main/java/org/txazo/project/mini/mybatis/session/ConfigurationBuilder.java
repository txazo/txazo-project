package org.txazo.project.mini.mybatis.session;

import org.txazo.project.mini.mybatis.datasource.DataSourceFactory;
import org.txazo.project.mini.mybatis.datasource.DruidDataSourceFactory;
import org.txazo.project.mini.mybatis.mapping.Environment;
import org.txazo.project.mini.mybatis.transaction.JdbcTransactionFactory;
import org.txazo.project.mini.mybatis.transaction.TransactionFactory;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationBuilder {

    private String mapperPackage;

    public ConfigurationBuilder(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public Configuration parse() {
        Configuration configuration = new Configuration();
        buildEnvironment(configuration);
        configuration.addMappers(mapperPackage);
        return configuration;
    }

    private void buildEnvironment(Configuration configuration) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        DataSourceFactory dataSourceFactory = new DruidDataSourceFactory(parseJdbcProps());
        Environment environment = new Environment.Builder()
                .dataSource(dataSourceFactory.getDataSource())
                .transactionFactory(transactionFactory)
                .build();
        configuration.setEnvironment(environment);
    }

    private Properties parseJdbcProps() {
        try {
            Properties props = new Properties();
            props.load(SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            return props;
        } catch (IOException e) {
            throw new RuntimeException("Error parseJdbcProps", e);
        }
    }

}
