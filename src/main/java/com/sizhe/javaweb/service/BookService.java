package com.sizhe.javaweb.service;

import com.sizhe.javaweb.bean.Book;
import com.sizhe.javaweb.dao.BookDao;

import java.util.List;

/**
 * @ClassName BookService
 * @Description BookService
 * @Author Chris
 * @Date 2021/5/28
 **/
public class BookService {
    private BookDao bookDao = new BookDao();

    public List<Book> searchAllBooks(int pageNum, int pageSize) {

        List<Book> books = bookDao.selectAll(pageNum, pageSize);

        return books;
    }

    public int countNum() {

        return bookDao.count();
    }
}
