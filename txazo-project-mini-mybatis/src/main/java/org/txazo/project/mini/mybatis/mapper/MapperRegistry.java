package org.txazo.project.mini.mybatis.mapper;

import org.txazo.project.mini.mybatis.exception.MapperNotFoundException;
import org.txazo.project.mini.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory<?>> mappers = new HashMap<>();

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (!mappers.containsKey(type)) {
                mappers.put(type, new MapperProxyFactory<>(type));
            }
        }
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) mappers.get(type);
        if (mapperProxyFactory == null) {
            throw new MapperNotFoundException();
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }

}
