package com.ted.shiro_demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :林溪
 * @date : 2023/1/30 18:02
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @GetMapping("/A")
    @RequiresRoles("A")
    public String role1(){
        System.out.println("A角色");
        return "A角色认证成功";
    }
    @GetMapping("/B")
    @RequiresRoles("B")
    public String role2(){
        System.out.println("B角色");
        return "B角色认证成功";
    }
    @GetMapping("/AB")
    @RequiresRoles(value = {"A","B"})
    public String role3(){
        System.out.println("AB角色");
        return "AB角色认证成功";
    }

    @GetMapping("/CC")
    @RequiresRoles(value = {"C","B"})
    public String role4(){
        System.out.println("CB角色");
        return "CB角色认证成功";
    }
}
