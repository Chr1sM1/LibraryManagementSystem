package com.sizhe.javaweb.dao;

import com.sizhe.javaweb.bean.Notification;
import com.sizhe.javaweb.utils.JDBCUtil;
import org.intellij.lang.annotations.Language;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NotificationDao
 * @Description NotificationDao
 * @Author Chris
 * @Date 2021/5/30
 **/
public class NotificationDao { public List<Notification> selectAll() {
    @Language("MySQL") String sql = "select * from announcement order by publish_date desc";

    List<Notification> notifications = new ArrayList<>();
    try (ResultSet rs =
                 JDBCUtil.getInstance().executeQueryRS(sql,
                         new Object[]{})) {

        while (rs.next()) {
            Notification notification = new Notification(rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("detail"),
                    rs.getDate("publish_date"));
            notifications.add(notification);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return notifications;
}

    public int count() {
        @Language("MySQL")String sql = "select count(*) as countNum from announcement";
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql,
                             new Object[]{})) {

            while (rs.next()) {
                int count = rs.getInt("countNum");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int insertNotification(String title, String detail) {
        @Language("MySQL")String sql = "insert into announcement(title, detail,publish_date) values(?,?,?)";
        int result = JDBCUtil.getInstance().executeUpdate(sql,
                new Object[]{
                        title, detail,
                        new Date(System.currentTimeMillis())
                });
        return result;
    }
}
