package org.txazo.project.mini.mybatis.session;

import org.txazo.project.mini.mybatis.executor.Executor;
import org.txazo.project.mini.mybatis.executor.SimpleExecutor;

public class DefaultSqlSession implements SqlSession {

    private Executor executor = new SimpleExecutor();

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> mapperClass) {
        return null;
    }

}
