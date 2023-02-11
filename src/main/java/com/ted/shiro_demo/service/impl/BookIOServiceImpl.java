package com.ted.shiro_demo.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ted.shiro_demo.entity.BookIO;
import com.ted.shiro_demo.mapper.BookIOMapper;
import com.ted.shiro_demo.service.BookIOService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author :林溪
 * @date : 2023/2/11 15:54
 */
@Service
public class BookIOServiceImpl extends ServiceImpl<BookIOMapper,BookIO> implements BookIOService {
    @Autowired
    private BookIOMapper bookIOMapper;
    @Override
    public List<BookIO> searchBookIO(String userName, String bookName, String startTime, String endTime, String brType) {
        return bookIOMapper.searchBookIO(userName,bookName,startTime,endTime,brType);
    }

    @Override
    public Integer insertBorrow(BookIO bookIO) {
        bookIO.setId(0);
        return bookIOMapper.insert(bookIO);
    }

    @Override
    public BookIO updatePre(Integer id) {
        return bookIOMapper.selectById(id);
    }

    @Override
    public Integer updateBorrow(BookIO bookIO) {
        return bookIOMapper.updateById(bookIO);
    }

    @Override
    public Integer updateStatus(Integer id) {
        BookIO bookIO = bookIOMapper.selectById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String format = simpleDateFormat.format(new Date());
        bookIO.setReturnTime(format);
        return bookIOMapper.updateById(bookIO);
    }


}
