package com.sizhe.javaweb.dao;

import com.sizhe.javaweb.bean.User;
import com.sizhe.javaweb.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName LoginDao
 * @Description LoginDao
 * @Author Chris
 * @Date 2021/5/25
 **/
public class LoginDao {

    public User selectOne(String username) {
        User user = null;
        try (ResultSet resultSet =
                     JDBCUtil.getInstance().executeQueryRS("select " +
                                     "* " +
                                     "from " +
                                     "borrow_card where username=?",
                             new Object[]{username})) {

            while (resultSet.next()) {
                user = new User(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("reader"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}