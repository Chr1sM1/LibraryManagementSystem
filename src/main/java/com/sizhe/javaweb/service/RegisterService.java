package com.sizhe.javaweb.service;

import com.sizhe.javaweb.bean.User;
import com.sizhe.javaweb.dao.LoginDao;
import com.sizhe.javaweb.dao.RegisterDao;

import java.sql.SQLException;

/**
 * @ClassName RegisterService
 * @Description TODO
 * @Author Chris
 * @Date 2021/5/25
 **/
public class RegisterService {
    private RegisterDao registerDao=new RegisterDao();

    public String  register(User register) throws SQLException {
        String result=String.valueOf(registerDao.register(register));

        if (result.equals("0")){
            return "注册失败";
        }else {
            return "注册成功";
        }
    }

}
