package org.txazo.project.mini.mybatis.test;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.project.mini.mybatis.session.DefaultSqlSessionFactory;
import org.txazo.project.mini.mybatis.session.SqlSession;
import org.txazo.project.mini.mybatis.session.SqlSessionFactory;

public class MiniMyBatisTest {

    @Test
    public void test() {
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        Assert.assertNotNull(user);
    }

}
