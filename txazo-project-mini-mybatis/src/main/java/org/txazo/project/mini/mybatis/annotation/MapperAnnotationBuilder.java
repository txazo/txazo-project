package org.txazo.project.mini.mybatis.annotation;

import org.txazo.project.mini.mybatis.session.Configuration;

import java.lang.reflect.Method;

public class MapperAnnotationBuilder {

    private Configuration configuration;
    private Class<?> type;

    public MapperAnnotationBuilder(Configuration configuration, Class<?> type) {
        this.configuration = configuration;
        this.type = type;
    }

    public void parse() {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            parseStatement(method);
        }
    }

    private void parseStatement(Method method) {

    }

}
