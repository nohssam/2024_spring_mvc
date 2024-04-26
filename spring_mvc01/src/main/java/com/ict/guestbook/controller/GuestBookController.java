package com.ict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.ict.edu4.service.DAO;
import com.ict.guestbook.service.GuestBookDAO;
import com.ict.guestbook.service.GuestBookVO;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookDAO guestBookDAO;
	
	@GetMapping("guestbook_go.do")
	public ModelAndView guestBookList() {
		ModelAndView mv = new ModelAndView("guestbook/list");
		List<GuestBookVO> list = guestBookDAO.guestBookList();
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("gb_write.do")
	public ModelAndView guestBookWrite() {
		
		// ModelAndView mv = new ModelAndView("guestbook/write");
		// return mv;
		
		return new ModelAndView("guestbook/write");
	}
	@PostMapping("gb_write_ok.do")
	public ModelAndView guestBookWriteOK(GuestBookVO gvo) {
		ModelAndView mv = new ModelAndView("redirect:guestbook_go.do");
		int result = guestBookDAO.guestBookInsert(gvo);
		if(result >0) {
			return mv;
		}
		/* return new ModelAndView("guestbook/error"); */
		return null;
	}
	
	@GetMapping("gb_detail.do")
	public ModelAndView guestBookDetail(GuestBookVO gvo) {
		ModelAndView mv = new ModelAndView("guestbook/onelist");
		GuestBookVO gbvo = guestBookDAO.guestBookDetail(gvo.getIdx());
		if(gbvo != null) {
			mv.addObject("gbvo", gbvo);
			return mv;
		}
		return null;
	}
	
	@PostMapping("gb_delete.do")
	public ModelAndView guestBookDelete(@ModelAttribute("gvo")GuestBookVO gvo) {
	   return new ModelAndView("guestbook/delete");
	}
	@PostMapping("gb_update.do")
	public ModelAndView guestBookUpdate(GuestBookVO gvo) {
		ModelAndView mv = new ModelAndView("guestbook/update");
		GuestBookVO gbvo = guestBookDAO.guestBookDetail(gvo.getIdx());
		if(gbvo != null) {
			mv.addObject("gbvo", gbvo);
			return mv;
		}
		return null;
	}
	
	@PostMapping("gb_delete_ok.do")
	public ModelAndView guestbookDeleteOK(String idx) {
		ModelAndView mv = new ModelAndView("redirect:guestbook_go.do");
		int result = guestBookDAO.guestBookDelete(idx);
		if(result > 0) {
			return mv;
		}
		return null;
	}
	
	@PostMapping("gb_update_ok.do")
	public ModelAndView gustbookUpdateOK(GuestBookVO gvo) {
		ModelAndView mv = new ModelAndView("redirect:gb_detail.do?idx="+gvo.getIdx());
		int result = guestBookDAO.guestBookUpDate(gvo);
		if(result > 0) {
			return mv;
		}
		return null;
	}
	
}












