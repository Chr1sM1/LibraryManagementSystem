package com.sizhe.javaweb.servlet;

import com.sizhe.javaweb.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddMessageServlet
 * @Description AddMessageServlet
 * @Author Chris
 * @Date 2021/5/30
 **/
@WebServlet(name = "AddMessageServlet", urlPatterns = "/messageBoard/add")
public class AddMessageServlet extends HttpServlet {

    private final MessageService messageService = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardId = req.getParameter("cardId");
        String detail = req.getParameter("detail");
        String result = messageService.addMessage(cardId, detail);
        resp.getWriter().print(result);
    }
}