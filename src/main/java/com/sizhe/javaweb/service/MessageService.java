package com.sizhe.javaweb.service;

import com.sizhe.javaweb.bean.Message;
import com.sizhe.javaweb.dao.MessageDao;

import java.util.List;

/**
 * @ClassName MessageService
 * @Description MessageService
 * @Author Chris
 * @Date 2021/5/30
 **/
public class MessageService {
    private final MessageDao messageDao = new MessageDao();

    public List<Message> queryAllMessage(int pageNum, int pageSize) {
        return messageDao.selectAll(pageNum, pageSize);
    }

    public int count() {
        return messageDao.count();
    }

    public String addMessage(String cardId, String detail) {
        int result = messageDao.insertMessage(cardId, detail);
        if (result > 0) {
            return "留言发布成功";
        } else {
            return "留言发布失败";
        }
    }
}
