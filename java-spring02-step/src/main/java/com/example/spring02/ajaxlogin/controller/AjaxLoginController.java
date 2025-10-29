package com.example.spring02.ajaxlogin.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring02.ajaxlogin.model.dto.AjaxLoginDTO;
import com.example.spring02.ajaxlogin.service.AjaxLoginService;


@Controller
@RequestMapping("ajaxlogin")
public class AjaxLoginController {

	private static final Logger log = LoggerFactory.getLogger(AjaxLoginController.class);
	
	@Inject
	private AjaxLoginService service;
	
	@RequestMapping("main.do")
	public String main() {
		log.info("ajaxlogin.main()");
		
		return "ajaxlogin/main";
		
	}
	
	@RequestMapping("writeform.do")
	public String writeForm() {
		log.info("ajaxlogin.writeForm()");
		
		return "ajaxlogin/writeForm";
	}
	
	@RequestMapping("write.do")
	public String write() {
		log.info("ajaxlogin.write()");
		
		return null;
	}
	
//	@ResponseBody
	@RequestMapping("checkid.do")
	public  String checkid(String id, Model model) {
		log.info("ajaxlogin.checkid()");
//		id = "kkk";
		id = service.checkId(id);
//		if(id.equals(service.checkId(id))) {
////			log.info("id == null");
//			return "id no!!중복된 아디입니다. 다른 아이디를 입력해 주세요";
//		}
//		System.out.println("controller id : " + id);
		model.addAttribute("id", id);
		return "ajaxlog/checkid";
		// 13.44
	}
	
	@ResponseBody
	@RequestMapping("ajaxcheckid.do")
	public  String ajaxcheckid(String id, Model model) {
		log.info("ajaxlogin.ajaxcheckid()");
		id = service.checkId(id);
		log.info("id : " + id);
		model.addAttribute("id", id);
		return "ajaxlog/checkid";
//		return ;
	}
}
