package com.ted.shiro_demo.config;

import com.ted.shiro_demo.relm.UserRelm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author :林溪
 * @date : 2023/1/18 20:48
 */
@Configuration
public class ShiroConfig {
    //获取bean
    @Autowired
    private UserRelm userRelm;

    //配置securityManager,加密规则与迭代次数
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        //1.创建对象 认证对象
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //2.创建加密对象,设置相关属性
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
            //采用MD5加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
            //迭代加密的次数
        hashedCredentialsMatcher.setHashIterations(4);
        //3.将加密对象存储到myRealm中
        userRelm.setCredentialsMatcher(hashedCredentialsMatcher);
        //4.将myRealm存入到defaultWebSecurityManager中
        defaultWebSecurityManager.setRealm(userRelm);

        //5.记住我 设置remember me
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        return defaultWebSecurityManager;
    }

    //cookie设置
    public SimpleCookie rememberMeCookie(){
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        //设置跨域
        //cookie.setDomain(domain)
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(30*24);
        return cookie;
    }

    //创建Shiro的cookie管理对象
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey("ZHANGXIAOHEI_CAT".getBytes());
        return cookieRememberMeManager;
    }

    //配置shiro的拦截范围
    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        //拦截对象
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        //定义hashMap,添加拦截规则
        HashMap<String,String> hm = new HashMap<>();
        hm.put("/**","authc");//所有资源均不允许被访问
        //除了
        hm.put("/login/login","anon");//发送的请求
        hm.put("/login/request","anon");//发送的请求
        //rememberMe功能配置
        hm.put("/**","user");
        //退出登录操作
        hm.put("/login/logout","logout");
        //将拦截规则放置在shiro过滤器中
        defaultShiroFilterChainDefinition.addPathDefinitions(hm);
        return defaultShiroFilterChainDefinition;
    }

}
