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
    private String id;
    private String name;
    private String author;
    private String sort;
    private String description;
    private boolean store;

    public Book(String id, String name, String author, String sort,
                String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sort = sort;
        this.description = description;
    }
}
