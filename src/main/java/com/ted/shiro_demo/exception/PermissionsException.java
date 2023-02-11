package com.ted.shiro_demo.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :林溪
 * @date : 2023/1/31 17:37
 */
@ControllerAdvice
public class PermissionsException {
    @ResponseBody //注意此项目集成了thymeleaf视图模板,需要返回字符串,则应当使用@ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationExceptionMethod(){
        return "您可能并没有此权限用于访问此页面";
    }
}
