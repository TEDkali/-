package com.ted.shiro_demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ted.shiro_demo.entity.Books;
import com.ted.shiro_demo.service.BookService;
import com.ted.shiro_demo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author :林溪
 * @date : 2023/2/10 15:05
 */
@RequestMapping("/books")
@Controller
public class BooksController {
    @Autowired
    private BookService bookService;

    /**
     * 书籍搜索
     * @param authority
     * @param bookName
     * @param type
     * @param page
     * @param model
     * @return
     */
    @GetMapping("/search")
    public String search(@RequestParam(value = "author",defaultValue = "")String authority,
                         @RequestParam(value = "bookName",defaultValue = "")String bookName,
                         @RequestParam(value = "type",defaultValue = "")String type,
                         @RequestParam(value = "page",defaultValue = "1")String page,
                         Model model){
        model.addAttribute("author",authority);
        model.addAttribute("bookName",bookName);
        model.addAttribute("type",type);
        Integer integer = Integer.valueOf(page);
        if(integer<=0){
            integer=1;
        }
        PageUtils search = bookService.search(authority, bookName, type,integer);
        model.addAttribute("ListBook",search.getList());//所有数据
        model.addAttribute("CurrPage",search.getCurrPage());//当前页
        model.addAttribute("TotalPage",search.getTotalPage()+1);//总页数
        return "innerHTML/bookList";
    }

    /**
     * 修改或新增书籍
     * @param books
     * @param model
     * @return
     */
    @PostMapping("/modify")
    public String modify(Books books,
                         Model model){
        System.out.println("需要修改或新增的数据为"+books);
        Integer success;
        if (books.getId()==null){
            System.out.println("新增数据");
            books.setId(0);
            success = bookService.insertBook(books);
        }else{
            System.out.println("更新数据");
            success = bookService.updateBook(books);
        }

        model.addAttribute("return","/innerHtml/modifyInfo.html");
        model.addAttribute("tips",success==1?"添加/修改成功":"添加/修改失败");
        return "innerHTML/tips";
    }

    /**
     * 根据id删除书籍
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id,Model model){
        System.out.println("需要删除的id"+id);
        Integer success = bookService.deleteBook(id);
        model.addAttribute("return","innerHTML/bookList.html");
        model.addAttribute("tips",success==1?"添加/修改成功":"添加/修改失败");
        return "innerHTML/tips";

    }

    /**
     * 根据id查询书籍信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updatePre/{id}")
    public String queryById(@PathVariable("id")Integer id, Model model){
        System.out.println("根据id"+id);
        Books books = bookService.queryById(id);
        model.addAttribute("book",books);
        System.out.println("需要修改的书籍为"+books);
        return "innerHTML/modifyInfo";
    }

}
