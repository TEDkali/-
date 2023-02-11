package com.ted.shiro_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ted.shiro_demo.entity.Books;
import com.ted.shiro_demo.mapper.BookMapper;
import com.ted.shiro_demo.service.BookService;
import com.ted.shiro_demo.utils.PageUtils;
import com.ted.shiro_demo.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author :林溪
 * @date : 2023/2/10 18:29
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Books> implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageUtils search(String author,String bookName,String type,Integer page){
        HashMap<String, Object> params = new HashMap<>();
        params.put("author",author);
        params.put("bookName",bookName);
        params.put("type",type);
        params.put("page",page);
        params.put("limit",10);
        System.out.println(params);
        IPage<Books> page1 = this.page(new Query<Books>().getPage(params), new QueryWrapper<Books>()
                .like(author != null, "author", author)
                .like(bookName != null, "name", bookName)
                .like(type != null, "type", type));
        PageUtils pageUtils = new PageUtils(page1);
        System.out.println(pageUtils);
        return pageUtils;
    }
    @Override
    public Integer countData(){
        Integer integer = bookMapper.selectCount(new QueryWrapper<>());
        return integer/10+1;
    }

    @Override
    public Integer updateBook(Books books) {
        return bookMapper.update(books,new UpdateWrapper<Books>().eq("id",books.getId()));
    }

    @Override
    public Integer insertBook(Books books) {
        return bookMapper.insert(books);
    }

    @Override
    public Integer deleteBook(Integer id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public Books queryById(Integer id) {
        Books books = bookMapper.selectById(id);
        return books;
    }


}
