package com.ted.shiro_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ted.shiro_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/1/18 20:08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据账户查询角色id
     * @param userName
     * @return integer
     */
    List<String> queryUserAuthority(@Param("userName")String userName);

    /**
     * 根据用账户查询角色
     * @param userName
     * @return
     */
    String queryRole(@Param("userName")String userName);


}
