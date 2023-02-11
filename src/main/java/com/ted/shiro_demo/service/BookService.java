package com.ted.shiro_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ted.shiro_demo.entity.Books;
import com.ted.shiro_demo.utils.PageUtils;
import org.apache.ibatis.annotations.Param;


/**
 * @author :林溪
 * @date : 2023/2/10 18:25
 */
public interface BookService extends IService<Books> {
    /**
     *
     * @param author
     * @param bookName
     * @param type
     * @param page
     * @return
     */
    public PageUtils search(String author, String bookName, String type, Integer page);

    Integer countData();
//
    Integer updateBook(Books books);

    Integer insertBook(Books books);

    Integer deleteBook(Integer id);

    Books queryById(Integer id);
}
