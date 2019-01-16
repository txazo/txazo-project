package org.txazo.project.mini.mybatis.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.txazo.project.mini.mybatis.session.SqlSession;
import org.txazo.project.mini.mybatis.session.SqlSessionFactory;
import org.txazo.project.mini.mybatis.session.SqlSessionFactoryBuilder;
import org.txazo.project.mini.mybatis.test.mapper.UserMapper;

public class MiniMyBatisTest {

    private static final String mapperPackage = "org.txazo.project.mini.mybatis.test.mapper";

    private UserMapper userMapper;

    @Before
    private void init() {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mapperPackage);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testInsert() {
        User user = new User("root", "123456");
        userMapper.insertUser(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testUpdate() {
        User user = new User(1, "root", "654321");
        userMapper.updateUser(user);
    }

    @Test
    public void testDelete() {
        userMapper.deleteUser(2);
    }

    @Test
    public void testSelect() {
        User user = userMapper.getUserById(1);
        Assert.assertNotNull(user);
    }

}
