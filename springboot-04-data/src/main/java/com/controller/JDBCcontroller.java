package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController//返回不会跳转到视图
public class JDBCcontroller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 没有实体类
    @GetMapping("/userlist")
    public List<Map<String, Object>> userList() {
        System.out.println("=======" + jdbcTemplate.getDataSource());
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into user(id,name,pwd) values (4,'xiaoming','123456')";
        jdbcTemplate.update(sql);
        return "ok";
    }


}
