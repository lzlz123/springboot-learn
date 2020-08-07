package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表明 这是一个 mybatis 的mapper 类
@Mapper
// 加入 spring
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User querryUserById(int id);

    int addUser(User user);

    int delete(int id);
}
