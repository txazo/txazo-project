package org.txazo.project.mini.mybatis.session;

import lombok.Data;
import org.txazo.project.mini.mybatis.binding.MapperRegistry;
import org.txazo.project.mini.mybatis.executor.Executor;
import org.txazo.project.mini.mybatis.executor.SimpleExecutor;
import org.txazo.project.mini.mybatis.mapping.Environment;
import org.txazo.project.mini.mybatis.transaction.Transaction;

import java.util.Properties;

@Data
public class Configuration {

    private Environment environment;
    private Properties jdbcProps = new Properties();
    private MapperRegistry mapperRegistry = new MapperRegistry(this);

    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor();
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

}
