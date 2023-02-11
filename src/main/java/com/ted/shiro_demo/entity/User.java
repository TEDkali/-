package com.ted.shiro_demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :林溪
 * @date : 2023/1/18 17:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    @TableId("id")
    private Integer id;
    @TableField("user_name")
    private String userName;
    @TableField("pwd")
    private String pwd;
    @TableField("salt")
    private String salt;
}
