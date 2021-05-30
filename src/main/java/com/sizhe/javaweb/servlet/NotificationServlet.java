package com.sizhe.javaweb.servlet;

import com.sizhe.javaweb.bean.Notification;
import com.sizhe.javaweb.service.NotificationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName NotificationServlet
 * @Description NotificationServlet
 * @Author Chris
 * @Date 2021/5/30
 **/
@WebServlet(name = "NotificationServlet", urlPatterns = "/notification/all")
public class NotificationServlet extends HttpServlet {
    private final NotificationService notificationService = new NotificationService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        List<Notification> notifications;
        int count;
        notifications = notificationService.queryAll();

        count = notificationService.count();
        req.getSession().setAttribute("notifications", notifications);
        resp.getWriter().print(count);
    }
}