package com.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServlet;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    //授权的规则
    public void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问 ， 功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认到登入页面
        http.formLogin().loginPage("/toLogin");

        http.csrf().disable();
        //注销功能,登出成功，跳到首页
        http.logout().logoutSuccessUrl("/");
        //记住我的功能
        http.rememberMe();
    }

    //认证
    @Override
    //密码加密
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //正常应该从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lizhen").password(new BCryptPasswordEncoder().encode("123")).roles("vip1", "vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123")).roles("vip1", "vip2", "vip3");
    }


}
