package com.sizhe.javaweb.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @ClassName Message
 * @Description Message
 * @Author Chris
 * @Date 2021/5/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    int id;
    int cardId;
    String detail;
    Date publicDate;
}
