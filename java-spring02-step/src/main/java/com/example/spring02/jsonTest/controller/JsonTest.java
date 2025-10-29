package com.example.spring02.jsonTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring02.jsonTest.model.dto.DataVO;


@Controller
@RequestMapping("jsontest")	
public class JsonTest {

	private static final Logger log = LoggerFactory.getLogger(JsonTest.class);
	
	@GetMapping("/getObject")
	public @ResponseBody DataVO getObject() {
		log.info("getObject() : ");
		DataVO vo = new DataVO();
		vo.setName("lee");
		vo.setAge(50);
		return vo;
	}
}
