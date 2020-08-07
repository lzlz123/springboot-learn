package com.lizhen.mapper;

import com.lizhen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User querryUserByName(String name);

    void addUser(User user);
}
