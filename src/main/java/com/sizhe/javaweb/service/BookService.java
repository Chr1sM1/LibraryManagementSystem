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

    public List<Book> searchAllBooks(String username, int pageNum,
                                     int pageSize) {

        List<Book> books = bookDao.selectAll(pageNum, pageSize);

        for (Book book : books) {
            book.setStore(isStar(username, book.getId()));
        }

        return books;
    }

    public int countNum() {

        return bookDao.count();
    }

    public boolean isStar(String username, String bookId) {
        return bookDao.isExist(username, bookId);
    }

    public String starBook(String username, String bookId) {
        int result = bookDao.insertBook(username, bookId);
        if (result > 0) {
            return "借阅成功";
        } else {
            return "借阅失败";
        }
    }
}
