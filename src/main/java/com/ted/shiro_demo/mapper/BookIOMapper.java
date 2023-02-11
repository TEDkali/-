package com.ted.shiro_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ted.shiro_demo.entity.BookIO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/2/11 14:33
 */
@Mapper
public interface BookIOMapper extends BaseMapper<BookIO> {
    List<BookIO> searchBookIO(@Param("userName")String userName,
                              @Param("bookName")String bookName,
                              @Param("startTime")String startTime,
                              @Param("endTime")String endTime,
                              @Param("brType")String brType);
}
