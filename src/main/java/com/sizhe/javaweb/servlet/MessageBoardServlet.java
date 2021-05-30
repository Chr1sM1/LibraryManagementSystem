package com.sizhe.javaweb.servlet;

import com.alibaba.fastjson.JSON;
import com.sizhe.javaweb.bean.Message;
import com.sizhe.javaweb.service.MessageService;
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
 * @ClassName MessageBoardServlet
 * @Description MessageBoardServlet
 * @Author Chris
 * @Date 2021/5/30
 **/
@WebServlet(name = "MessageBoardServlet", urlPatterns = "/messageBoard/all")
public class MessageBoardServlet extends HttpServlet {

    private final MessageService messageService = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String paramJson = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Message> messages = new ArrayList<>();
        int count = 0;
        messages = messageService.queryAllMessage(pageNum, pageSize);
        count = messageService.count();
        req.getSession().setAttribute("messages", messages);
        resp.getWriter().print(count);
    }
}
