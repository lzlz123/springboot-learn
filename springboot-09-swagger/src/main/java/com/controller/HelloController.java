package com.controller;

import com.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @PostMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    //只要外面的接口返回了实体类，就会被扫描到
    @ApiOperation("hello控制类")
    @PostMapping("/user")
    public User user() {
        return new User();
    }
}
