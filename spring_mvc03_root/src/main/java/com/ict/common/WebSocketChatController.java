package com.ict.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSocketChatController {
	private Map<String, ChatRoom> chatRooms = new HashMap<>();
	
	@GetMapping("/chat2.do")
	public ModelAndView Chat() {
		return new ModelAndView("chat/chatting");
	}

	@GetMapping("/chat3.do")
	public ModelAndView Chat2() {
		return new ModelAndView("chat/chatting2");
	}

	@MessageMapping("/chatroom.create")
    @SendToUser("/queue/chatroom/create")
    public ChatRoom createChatRoom(@Payload ChatRoom chatRoom, SimpMessageHeaderAccessor headerAccessor) {
        String roomId = headerAccessor.getSessionId();
        chatRoom.setId(roomId);
        chatRooms.put(roomId, chatRoom);
        return chatRoom;
    }

    @MessageMapping("/chatroom.join")
    public void joinChatRoom(@Payload ChatRoom chatRoom, SimpMessageHeaderAccessor headerAccessor) {
        String roomId = chatRoom.getId();
        headerAccessor.getSessionAttributes().put("room_id", roomId);
    }

    @MessageMapping("/chatroom.sendMessage")
    public void sendMessage(@Payload String message, SimpMessageHeaderAccessor headerAccessor) {
        String roomId = (String) headerAccessor.getSessionAttributes().get("room_id");
        // Handle message sending logic within the specific room
    }
}
