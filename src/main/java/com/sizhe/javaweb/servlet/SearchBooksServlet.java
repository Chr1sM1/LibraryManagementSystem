package com.sizhe.javaweb.servlet;

import com.alibaba.fastjson.JSON;
import com.sizhe.javaweb.bean.Book;
import com.sizhe.javaweb.bean.User;
import com.sizhe.javaweb.service.BookService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SearchBookServlet
 * @Description TODO
 * @Author Chris
 * @Date 2021/5/28
 **/
@WebServlet(name = "SearchBooksServlet", urlPatterns = "/book/search")
public class SearchBooksServlet extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        //1. 取参（req当前的页码, 每页的数量, 搜索）
        String paramJson = IOUtils.toString(
                req.getInputStream(), StandardCharsets.UTF_8);
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Book> books = new ArrayList<>();
        int count = 0;
        //2.
        if (param == null) {
            books = bookService.searchAllBooks(String.valueOf(((User)req.getSession().getAttribute("user")).getId()), pageNum, pageSize);
        }

        count = bookService.countNum();

        //3. 将结果放入session
        req.getSession().setAttribute("books", books);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}
