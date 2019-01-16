package org.txazo.project.mini.mybatis.binding;

import org.txazo.project.mini.mybatis.session.Configuration;
import org.txazo.project.mini.mybatis.session.SqlSession;

import java.lang.reflect.Method;

public class MapperMethod {

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {

    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        return null;
    }

}
