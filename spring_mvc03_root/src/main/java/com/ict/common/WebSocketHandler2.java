package com.ict.common;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// BinaryWebSocketHandler   :  이미지
// TextWebSocketHandler		:  단순 채팅
public class WebSocketHandler2 extends TextWebSocketHandler{

	Map<String, WebSocketSession> users =
			new HashMap<String, WebSocketSession>();
	
	@Override
	//클라이언트가 서버에 접속 성공시 호출
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("stomp affterConn");
		// sessionList.add(session);
		users.put(session.getId(), session);
	}
	
	@Override
	//소켓에 메세지를 보냈을 때 호출
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("stomp handleTextMessage");
		String msg = message.getPayload();
		System.out.println("msg : " + msg);
		TextMessage tMsg = new TextMessage(msg.substring(4));
		Collection<WebSocketSession> list = users.values();
		
		for(WebSocketSession k : list) {
			k.sendMessage(tMsg);
		}
	}
	
	@Override
	//연결이 종료됐을 때
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session.getId());
	}
}
