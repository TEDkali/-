package com.ted.shiro_demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :林溪
 * @date : 2023/2/10 16:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_books")
public class Books {
    @TableId("id")
    private Integer id;
    @TableField("author")
    private String author;
    @TableField("isbn")
    private String isbn;
    @TableField("name")
    private String name;
    private Integer pages;
    private Double price;
    private String publish;
    @TableField("publish_time")
    private String publishTime;
    private Integer size;
    private String type;

}
