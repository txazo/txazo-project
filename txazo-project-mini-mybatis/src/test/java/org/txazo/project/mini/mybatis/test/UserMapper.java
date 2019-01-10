package org.txazo.project.mini.mybatis.test;

import org.txazo.project.mini.mybatis.annotation.Insert;
import org.txazo.project.mini.mybatis.annotation.Select;

public interface UserMapper {

    @Insert(value = "insert into user(username, password) values(#{userName}, #{password})", parameterType = User.class)
    User insertUser(User user);

    @Select(value = "select * from user where id = ?", resultType = User.class)
    User getUserById(Integer id);

}
