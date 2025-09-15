package com.example.spring02.chart.google.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.login.controller.LoginController;

@RestController		// json 형태로 리턴하는 method가 있는 경우
@RequestMapping("chart")
public class GoogleChartController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("google1.do")
	// @RequestBody : @RestController 또는 @RequestBody로 json 형태로 출력한다
	public ModelAndView google1() {
		log.info("google1");
		
		return new ModelAndView("/chart/google/google1");
	}
}
