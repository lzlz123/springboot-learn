package com.lizhen.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //shiroFilteFactoryBean

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加 shiro 的内置过滤器
        /*
         *  anno： 无需认证
         *  authc： 必须认证
         *  user： 必须用于 记住我  功能才能访问
         *  perm： 拥有对某个资源的权限才能访问
         *  role： 拥有某个角色的权限才能访问
         *
         * */
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登入的请求
        bean.setLoginUrl("/toLogin");

        //设置未授权页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;

    }


    //DefaultWebSecutiryManager
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager get(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联 userRealm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //创建 realm 对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


    //整合 shiroDialect 和 thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }


}
