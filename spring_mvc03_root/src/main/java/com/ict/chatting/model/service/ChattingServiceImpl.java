package com.ict.chatting.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ict.chatting.model.dao.ChattingDao;
import com.ict.chatting.vo.Message;





@Service
public class ChattingServiceImpl implements ChattingService{

    @Autowired
    private ChattingDao chattingDao;
    
    @Override
    public int insertMessage(Message msg) {
        return chattingDao.insertMessage(msg);
    }

	@Override
	public Message selectChatRequest(String memberID) {
		return chattingDao.selectChatRequest(memberID);
	}

	@Override
	public int deleteMessage(Message message) {
		return chattingDao.deleteMessage(message);
	}

	@Override
	public int selectReceiver(String memberID) {
		return chattingDao.selectReceiver(memberID);
	}
}