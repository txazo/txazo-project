package org.txazo.project.mini.mybatis.test.mapper;

import org.txazo.project.mini.mybatis.annotation.*;
import org.txazo.project.mini.mybatis.test.User;

public interface UserMapper {

    @Insert(value = "insert into user(username, password) values(#{userName}, #{password})",
            keyProperty = "id", useGeneratedKeys = true)
    int insertUser(User user);

    @Update(value = "update user set username = #{userName}, password = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete(value = "delete from user where id = #{id}")
    int deleteUser(@Param("id") Integer id);

    @Select(value = "select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

}
