package com.ted.shiro_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ted.shiro_demo.entity.User;
import com.ted.shiro_demo.mapper.UserMapper;
import com.ted.shiro_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/1/18 20:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户名查询用户
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("user_name",userName));
    }

    /**
     * 通过用户名查询权限
     * @param userName
     * @return
     */
    @Override
    public List<String> queryUserAuthority(String userName) {
        return userMapper.queryUserAuthority(userName);
    }

    /**
     * 通过用户名查询角色
     * @param userName
     * @return
     */
    @Override
    public String queryRole(String userName) {
        return userMapper.queryRole(userName);
    }
}
