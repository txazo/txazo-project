package org.txazo.project.mini.mybatis.session;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(String mapperPackage) {
        ConfigurationBuilder parser = new ConfigurationBuilder(mapperPackage);
        return build(parser.parse());
    }

    private SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }

}
