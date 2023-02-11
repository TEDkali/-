package com.ted.shiro_demo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :林溪
 * @date : 2023/1/31 21:54
 */
@Configuration
public class ShiroDialectConfig {
    @Bean //创建bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }
}
