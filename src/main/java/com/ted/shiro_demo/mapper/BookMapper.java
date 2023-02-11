package com.ted.shiro_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ted.shiro_demo.entity.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

/**
 * @author :林溪
 * @date : 2023/2/10 18:03
 */
@Mapper
public interface BookMapper extends BaseMapper<Books> {
    /**
     * 搜索功能
     * @param author
     * @param bookName
     * @param type
     * @return
     */
    List<Books> search(@Param("author")String author,
                       @Param("bookName")String bookName,
                       @Param("type")String type);

    //Integer updateBook(Books books);

    //Integer insertBook(Books books);

    //Integer deleteBook(@Param("id")Integer id);

    //Integer queryById(@Param("id")Integer id);
}
