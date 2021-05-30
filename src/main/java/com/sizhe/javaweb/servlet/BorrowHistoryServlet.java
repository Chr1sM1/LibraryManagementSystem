package com.sizhe.javaweb.servlet;

import com.sizhe.javaweb.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String uid = req.getParameter("uid");
        String bookId = req.getParameter("bookId");
        String result = bookService.borrowBook(uid, bookId);
        resp.getWriter().print(result);
    }
}
