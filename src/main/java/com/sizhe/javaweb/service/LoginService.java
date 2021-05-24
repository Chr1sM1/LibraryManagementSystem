package com.sizhe.javaweb.service;

import com.sizhe.javaweb.bean.User;
import com.sizhe.javaweb.dao.LoginDao;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginService
 * @Description LoginService
 * @Author Chris
 * @Date 2021/5/25
 **/
public class LoginService {

    private LoginDao loginDao = new LoginDao();

    public String login(String username, String password,
                        HttpSession session) {
        User user = loginDao.selectOne(username);
        if (user == null) {
            return "用户不存在";
        } else {
            if (password.equals(user.getPassword())) {
                session.setAttribute("user", user);
                session.setAttribute("isLogin", true);
                return "1";
            } else {
                return "密码错误";
            }
        }
    }
}