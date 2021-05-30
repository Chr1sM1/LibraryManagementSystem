package com.sizhe.javaweb.service;

import com.sizhe.javaweb.bean.Notification;
import com.sizhe.javaweb.dao.NotificationDao;

import java.util.List;

/**
 * @ClassName NotificationService
 * @Description NotificationService
 * @Author Chris
 * @Date 2021/5/30
 **/
public class NotificationService {
    private final NotificationDao notificationDao = new NotificationDao();

    public List<Notification> queryAll() {
        return notificationDao.selectAll();
    }

    public int count() {
        return notificationDao.count();
    }

    public String addNotification(String title, String detail) {
        int result = notificationDao.insertNotification(title, detail);
        if (result > 0) {
            return "新建通知成功";
        } else {
            return "新建通知失败";
        }
    }
}
