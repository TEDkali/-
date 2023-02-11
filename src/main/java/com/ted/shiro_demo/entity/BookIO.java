package com.ted.shiro_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :林溪
 * @date : 2023/2/11 14:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookIO {
    private Integer id;
    private String userName;
    private Integer userId;
    private String name;
    private Integer booksId;
    private Integer number;
    private String borrowTime;
    private String returnTime;
}
