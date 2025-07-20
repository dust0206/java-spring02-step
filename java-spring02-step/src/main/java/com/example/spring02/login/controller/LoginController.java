package com.example.spring02.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.login.model.dto.LoginVO;
import com.example.spring02.login.service.LoginService;



@Controller	
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private LoginService loginService;
	
	@RequestMapping("member/login.do")
	public String login() {
		log.info(" # login() #");
		
		return "member/login";
	}
	
	@RequestMapping("member/login_check.do")
	public ModelAndView login_check(@ModelAttribute LoginVO vo, HttpSession session) {
		log.info(" # login_check() #");
		boolean result = loginService.loginCheck(vo,session); 
		
		log.info("result : " + result);
		ModelAndView mav = new ModelAndView();
		if(result == true) {	// 로그인 성공
			// main.jsp로 이동
			mav.setViewName("main");
			mav.addObject("message","success");
			log.info("result true : " + result);
		} else {
			// login.jsp로 이동
			log.info("result false : " + result);
			mav.setViewName("member/login");
			mav.addObject("message","error");
		}
		
		return mav;
	}
	
	@RequestMapping("member/logout.do")
	public ModelAndView logout(HttpSession session) {
		log.info(" # logout() #");
		loginService.logout(session) ;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		
		return mav;
	}
}
