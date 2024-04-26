package com.ict.email.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.email.service.MailService;

@Controller
public class EmailController {
	@Autowired
	private MailService mailService;
	
	@GetMapping("email_send.do")
	public ModelAndView sendMail() {
		return new ModelAndView("email/email_form");
	}
	@PostMapping("email_send_ok.do")
	public ModelAndView sendMailOK(String email) {
		try {
			// 임시번호 만들기 
			Random random = new Random();
			String randomNumber = String.valueOf(random.nextInt(1000000) % 1000000);
	        if(randomNumber.length() < 6) {
	            int substract = 6 - randomNumber.length();
	            StringBuffer sb = new StringBuffer();
	            for(int i=0; i<substract; i++) {
	                sb.append("0");
	            }
	            sb.append(randomNumber);
	            randomNumber = sb.toString();
	        }
	        // 임시번호 서버에 출력
	        System.out.println("임시번호 : " + randomNumber);
	        
	        // 임시번호를 DB에 저장 해야 된다.
	        
	        // 사용자메일에 임시번호 보내기 
	        mailService.sendEmail(randomNumber, email);
	        
	        return new ModelAndView("email/email_chk");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("email/error");
	}
}
