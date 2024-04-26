package com.ict.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxController {
	@GetMapping("spring_ajax_go.do")
	public ModelAndView getStringAjax() {
		return new ModelAndView("ajax/ajax_exam");
	}
	
	@GetMapping("spring_ajax_go2.do")
	public ModelAndView getStringAjax2() {
		return new ModelAndView("ajax/ajax_exam2");
	}
	
	@GetMapping("data_go.do")
	public ModelAndView getDataGo() {
		return new ModelAndView("ajax/ajax_exam3");
	}
	@GetMapping("data_go2.do")
	public ModelAndView getDataGo2() {
		return new ModelAndView("ajax/ajax_exam4");
	}
}
