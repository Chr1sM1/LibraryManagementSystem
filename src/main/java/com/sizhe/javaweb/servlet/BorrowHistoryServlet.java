package com.sizhe.javaweb.servlet;

import com.alibaba.fastjson.JSON;
import com.sizhe.javaweb.bean.Book;
import com.sizhe.javaweb.service.BookService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName BorrowHistoryServlet
 * @Description BorrowHistoryServlet
 * @Author Chris
 * @Date 2021/5/30
 **/
@WebServlet(name = "BorrowHistoryServlet", urlPatterns = "/book/borrowHistory")
public class BorrowHistoryServlet extends HttpServlet {

    private final BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramJson = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("uid");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Book> books = bookService.queryBorrowBook(param,pageNum, pageSize);
        req.getSession().setAttribute("borrowbooks", books);
    }
}
