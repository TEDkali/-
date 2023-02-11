package com.ted.shiro_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ted.shiro_demo.entity.BookIO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/2/11 15:51
 */
public interface BookIOService extends IService<BookIO> {
    /**
     * 条件查询
     * @param userName
     * @param bookName
     * @param startTime
     * @param endTime
     * @param brType
     * @return
     */
    List<BookIO> searchBookIO(String userName,
                              String bookName,
                              String startTime,
                              String endTime,
                              String brType);

    Integer insertBorrow(BookIO bookIO);

    BookIO updatePre(Integer id);

    Integer updateBorrow(BookIO bookIO);

    Integer updateStatus(Integer id);

}
