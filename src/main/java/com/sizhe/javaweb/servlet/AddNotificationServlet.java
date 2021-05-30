package com.sizhe.javaweb.servlet;

import com.sizhe.javaweb.service.NotificationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddNotificationServlet
 * @Description AddNotificationServlet
 * @Author Chris
 * @Date 2021/5/30
 **/

@WebServlet(name = "AddMessageServlet", urlPatterns = "/notification/add")
public class AddNotificationServlet extends HttpServlet {
    private final NotificationService notificationService = new NotificationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String notification = req.getParameter("notification");
        String result = notificationService.addNotification(title, notification);
        resp.getWriter().print(result);
    }
}
