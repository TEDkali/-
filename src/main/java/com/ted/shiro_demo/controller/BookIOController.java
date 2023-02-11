package com.ted.shiro_demo.controller;

import com.ted.shiro_demo.entity.BookIO;
import com.ted.shiro_demo.service.BookIOService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author :林溪
 * @date : 2023/2/11 15:56
 */
@Controller
@RequestMapping("/bookIO")
public class BookIOController {
    @Autowired
    private BookIOService BookIOService;

    /**
     * 搜索借还记录
     * @param userName
     * @param bookName
     * @param startTime
     * @param endTime
     * @param brType
     * @return
     */
    @GetMapping("/search")
    public String search(@RequestParam(value = "userName",defaultValue = "")String userName,
                         @RequestParam(value = "bookName",defaultValue = "")String bookName,
                         @RequestParam(value = "startTime",defaultValue = "")String startTime,
                         @RequestParam(value = "endTime",defaultValue = "")String endTime,
                         @RequestParam(value = "brType",defaultValue = "")String brType,
                         @RequestParam(value = "page",defaultValue = "1")Integer page,
                         Model model){
        System.out.println("查询的时间类型为"+brType);
        List<BookIO> bookIOS = BookIOService.searchBookIO(userName, bookName, startTime, endTime, brType);
        model.addAttribute("data",bookIOS);
        return "innerHTML/bookIOList";
    }

    @GetMapping("/updatePre/{id}")
    public String updatePre(@PathVariable("id")Integer id,
                            Model model){
        BookIO bookIO = BookIOService.updatePre(id);
        model.addAttribute("data",bookIO);
        return "";

    }

    @GetMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable("id")Integer id){

        return "";
    }

    @GetMapping("/modifyBorrow")
    public String modifyBorrow(BookIO bookIO,Model model){
        Integer success;
        if(bookIO.getId()!=null){
            success = BookIOService.updateBorrow(bookIO);
        }else{
            success = BookIOService.insertBorrow(bookIO);
        }
        model.addAttribute("tips",success==1?"修改/新增成功":"修改/新增失败");
        model.addAttribute("return","bookIO/search");
        return "innerHTML/tips";
    }

    @GetMapping("/myBorrow")
    public String myBorrow(Model model){
        String principal = (String)SecurityUtils.getSubject().getPrincipal();
        System.out.println("当前用户名"+principal);
        List<BookIO> bookIOS = BookIOService.searchBookIO(principal, "", "", "", "");
        model.addAttribute("data",bookIOS);
        return "innerHTML/bookIOList";
    }


}
