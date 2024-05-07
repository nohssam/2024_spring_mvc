package com.ict.chatting.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.chatting.vo.Message;





@Repository
public class ChattingDao {
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insertMessage(Message msg) {
        return sqlSessionTemplate.insert("chatting.insertMessage", msg);
    }

	public Message selectChatRequest(String memberID) {
		return sqlSessionTemplate.selectOne("chatting.selectChatRequest", memberID);
	}

	public int deleteMessage(Message message) {
		return sqlSessionTemplate.delete("chatting.deleteMessage", message);
	}

	public int selectReceiver(String memberID) {
		return sqlSessionTemplate.selectOne("chatting.selectReceiver", memberID);
	}

}