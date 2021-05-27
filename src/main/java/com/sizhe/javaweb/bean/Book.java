package com.sizhe.javaweb.bean;

/**
 * @ClassName Book
 * @Description Book
 * @Author Chris
 * @Date 2021/5/27
 **/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private String author;
    private String sort;
    private String description;
}
