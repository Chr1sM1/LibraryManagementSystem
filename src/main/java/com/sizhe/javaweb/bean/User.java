package com.sizhe.javaweb.bean;

/**
 * @ClassName User
 * @Description User
 * @Author Chris
 * @Date 2021/5/25
 **/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String username;
    private String password;
    private String reader;


}