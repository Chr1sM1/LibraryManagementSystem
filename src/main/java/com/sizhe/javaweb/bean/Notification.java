package com.sizhe.javaweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @ClassName Notification
 * @Description Notification
 * @Author Chris
 * @Date 2021/5/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    int id;
    String title;
    String detail;
    Date publishDate;
}
