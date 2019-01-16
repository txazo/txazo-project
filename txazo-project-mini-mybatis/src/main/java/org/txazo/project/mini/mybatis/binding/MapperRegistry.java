package org.txazo.project.mini.mybatis.binding;

import org.txazo.project.mini.mybatis.annotation.MapperAnnotationBuilder;
import org.txazo.project.mini.mybatis.exception.MapperNotFoundException;
import org.txazo.project.mini.mybatis.session.Configuration;
import org.txazo.project.mini.mybatis.session.SqlSession;
import org.txazo.project.mini.mybatis.util.PackageUtil;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private final Configuration configuration;
    private final Map<Class<?>, MapperProxyFactory<?>> mappers = new HashMap<>();

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    public void addMappers(String packageName) {
        for (Class<?> mapperClass : PackageUtil.scan(packageName)) {
            addMapper(mapperClass);
        }
    }

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (!mappers.containsKey(type)) {
                mappers.put(type, new MapperProxyFactory<>(type));

                MapperAnnotationBuilder parser = new MapperAnnotationBuilder(configuration, type);
                parser.parse();
            }
        }
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) mappers.get(type);
        if (mapperProxyFactory == null) {
            throw new MapperNotFoundException("Type " + type + " is not known to the MapperRegistry.");
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }

}
