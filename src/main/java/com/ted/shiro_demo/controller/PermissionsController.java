package com.ted.shiro_demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :林溪
 * @date : 2023/1/31 16:51
 */
@RestController
@RequestMapping("/Permissions")
public class PermissionsController {
    @GetMapping("/query")
    @RequiresPermissions("query")
    public String query(){
        System.out.println("该角色拥有query");
        return "query success";
    }
    @GetMapping("/delete")
    @RequiresPermissions("delete")
    public String delete(){
        System.out.println("delete");
        return "delete success";
    }
    @GetMapping("/update")
    @RequiresPermissions("update")
    public String update(){
        System.out.println("update");
        return "update success";
    }
    @GetMapping("/insert")
    @RequiresPermissions("insert")
    public String insert(){
        System.out.println("insert");
        return "insert success";
    }
}
