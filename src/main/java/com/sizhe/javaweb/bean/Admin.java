package com.sizhe.javaweb.bean;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author Chris
 * @Date 2021/5/26
 **/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Admin {
    private String username;
    private String password;
}
