package com.ted.shiro_demo.controller;

import com.ted.shiro_demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author :林溪
 * @date : 2023/1/18 20:17
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        System.out.println("访问登录页面");
        return "login";
    }

    @GetMapping("/main")
    public String main(){
        System.out.println("主页");
        return "main";
    }
    @GetMapping("/eooro")
    public String eooro(){
        System.out.println("错误页面");
        return "eooro";
    }

    @GetMapping("/request")
    public String request(@RequestParam("userName")String userName,
                          @RequestParam("pwd")String pwd,
                          @RequestParam(value = "rememberMe",defaultValue = "false")boolean rememberMe,
//                          HttpSession request,
                          Model model){
        model.addAttribute("userName",userName);
        System.out.println("前端传入的对象"+userName+","+pwd);
        System.out.println("是否记住我"+rememberMe);
        //1.获取subject的对象
        Subject subject = SecurityUtils.getSubject();
        //2.封装请求数据到token
        AuthenticationToken authenticationToken = new UsernamePasswordToken(userName,pwd,rememberMe);
        //使用login方法进行登录认证
        try {
            subject.login(authenticationToken);
            System.out.println("登录成功");

//            request.setAttribute("user",new User(null,userName,pwd,"salt no"));
            return "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("message","账号不存在或者密码错误");
            System.out.println("登录失败");
            return "login";
        }
    }
}
