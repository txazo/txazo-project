package org.txazo.project.mini.mybatis.mapper;

import org.txazo.project.mini.mybatis.session.SqlSession;

public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        return null;
    }

}
