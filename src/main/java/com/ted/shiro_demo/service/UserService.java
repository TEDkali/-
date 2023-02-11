package com.ted.shiro_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ted.shiro_demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/1/18 20:10
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户名查询账号
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 根据用户名查询权限
     * @param userName
     * @return
     */
    List<String> queryUserAuthority(String userName);

    /**
     * 根据用户名查询角色
     * @param userName
     * @return
     */
    String queryRole(String userName);
}
