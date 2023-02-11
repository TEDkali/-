package com.ted.shiro_demo.relm;

import com.ted.shiro_demo.entity.User;
import com.ted.shiro_demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/1/18 20:22
 */
@Component
public class UserRelm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1.获取当前用户的身份信息  ..获取username
        String s = principals.getPrimaryPrincipal().toString();
        System.out.println("当前角色为"+s);
        //创建对象
        SimpleAuthorizationInfo si = new SimpleAuthorizationInfo();
        //获得权限
        List<String> authorityList = userService.queryUserAuthority(s);
        System.out.println("该用户的权限有"+authorityList);
        //获得角色
        String role = userService.queryRole(s);
        si.addRole(role);
        si.addStringPermissions(authorityList);
        //返回
        return si;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken)token;
        //获取用户名
        String username = upt.getUsername();
        System.out.println("用户名:"+username+"/n"+upt);
        //根据用户名去数据库查询
        User userByUserName = userService.getUserByUserName(username);
        if(userByUserName != null){
            //1.token认证,2.数据库密码,3.盐值,4.getName()
            SimpleAuthenticationInfo s = new SimpleAuthenticationInfo(
                    token.getPrincipal(),
                    userByUserName.getPwd(),
                    ByteSource.Util.bytes(userByUserName.getSalt()),
                    getName());
            return s;
        }
        return null;
    }
}
