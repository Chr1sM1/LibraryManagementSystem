package com.sizhe.javaweb.bean;

/**
 * @ClassName User
 * @Description User
 * @Author Chris
 * @Date 2021/5/25
 **/
public class User {
    private String username;
    private String password;
    private String reader;

    public User() {
    }

    public User(String username, String password, String reader) {
        this.username = username;
        this.password = password;
        this.reader = reader;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }
}