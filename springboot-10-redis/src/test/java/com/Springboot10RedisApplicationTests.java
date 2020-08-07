package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("lizhen", "123");
        System.out.println(redisTemplate.opsForValue().get("lizhen"));
    }

    @Test
    void test() throws JsonProcessingException {
        User user = new User("llll", 3);
        String s = new ObjectMapper().writeValueAsString(user);
        System.out.println(s);
        redisTemplate.opsForValue().set("user", user);
        System.out.println("++++++++:" + redisTemplate.opsForValue().get("user").toString());
    }

}
