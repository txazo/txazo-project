package org.txazo.project.mini.mybatis.session;

public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T getMapper(Class<T> type);

    Configuration getConfiguration();

}
