package com.example.spring02.chart.chartjs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.login.controller.LoginController;

@Controller
@RequestMapping("chartjs")
public class ChartjsController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("chartjslist.do")
	// @RequestBody : @RestController 또는 @RequestBody로 json 형태로 출력한다
	public String  chartjslist() {
		log.info("list");
		
		return "chart/chartjs/chartjslist";
	}
}



 