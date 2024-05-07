package com.ict.chatting.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.chatting.model.service.ChattingService;
import com.ict.chatting.vo.Member;
import com.ict.chatting.vo.Message;


@Controller
public class ChattingController {
    
    @Autowired
    private ChattingService chattingService;
    
    // 채팅 생성 및 대기 페이지 이동
    @RequestMapping("chattingPage.do")
    public String chatting() {
        return "chatting/unicast";
    }

    // 채팅 요청 입력
    @RequestMapping(value="chatRequest.do", method= RequestMethod.POST)
    public void chatRequest(
    		@RequestParam("textMessage") String textMessage,
    		@RequestParam("sender") String sender,
    		@RequestParam("receiver") String receiver) {
    	Message message = new Message(textMessage, sender, receiver, "Y");
    	chattingService.insertMessage(message);
    }
    
    // 채팅 대상 확인
    @RequestMapping(value="checkMember.do", method= RequestMethod.POST)
    public void checkMember(
    		@RequestParam("memberID") String memberID, HttpServletResponse response) throws IOException {
    	
    	int result = 1;
    	// result = chattingService.selectReceiver(memberID);
    	
		String returnStr = null;
		if(result > 0) {
			returnStr = "exist";
		}else {
			returnStr = "failed";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(returnStr);
		out.flush();
		out.close();
		}
    
    
    // 채팅 요청 여부 확인
    @RequestMapping("enterChat.do")
    public String chatResponse(HttpServletRequest request, Model model) {
    	Member member = (Member)request.getSession().getAttribute("loginMember");
    	
    	Message message = chattingService.selectChatRequest(member.getMemberID());
    	
    	if(message != null) {
    		model.addAttribute("sender", message.getSender());
    		return "chatting/unicast2";
    	}else {
    		model.addAttribute("error", "잘못된 요청입니다.");
    		return "common/error";
    	}
    }
    
    // 채팅 요청 응답 또는 연결 종료 시  요청대기 삭제
    @RequestMapping(value="removeRequest.do", method=RequestMethod.POST)
    public void removeRequest(
    		@RequestParam("sender") String sender,
    		@RequestParam("receiver") String receiver) {
    	Message message = new Message();
    	message.setReceiver(receiver);
    	message.setSender(sender);
    	
    	chattingService.deleteMessage(message);
    }
    
    // 채팅 요청 응답 또는 연결 종료 시  요청대기 삭제
    @RequestMapping(value="cleanChat.do", method=RequestMethod.POST)
    public void cleanChat(HttpSession session) {
    	session.removeAttribute("chatOn");
    }
    
}