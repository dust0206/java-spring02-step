package com.example.spring02.part1_ch05;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// src/main/java에 클래스 추가
@Controller	// 컨트롤러 bean으로 로딩
public class SampleController {
	// 로그 객체 생성
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("part1_ch05/doA")		// url pattern
	public void doA(Model model) {
		log.info("## doA()  called...");	// 로그 출력
		// model.addAttribute(key, value)
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		// 리턴 타입이 void이면 method가 종료된후 method가 종료된 후 doA.jsp로 포워드됨
	}
	@RequestMapping("part1_ch05/doA1")		// url pattern
	public String doA1(Model model) {
		log.info("## doA1()  called...");	// 로그 출력
		// model.addAttribute(key, value)
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		// 리턴 타입이 String이면 method 명으로 포워드 됨
		return "part1_ch05/doB";
	}
	
	@RequestMapping("part1_ch05/doB")
	public void doB() {
		log.info("## doB()  called...");
		// method가 종료된 후 doB.jsp로 포워드됨
	}
	
	// ModelAndView : Model - 데이터 저장소, View 화면 
	// => 데이터 저장와 포워딩할 페이지의 정보를 가지고 있다 
	// forward : 주소 그대로, 화면 전환, 대량의 데이터 전달
	// redirect : 주소 바뀜, 화면 전환, 소량의 get 방식 데이터
	@RequestMapping("part1_ch05/doC")
	public ModelAndView doC() {
		log.info("## doC ##");
		// 맵에 객체 저장
		Map<String, Object> map = new HashMap<>();
		map.put("product", new ProductVO("샤프", 1000));
		
		// new ModelAndView("view의 이름", "Map 변수명", map)
		return new ModelAndView("part1_ch05/doC", "map", map);
	}
	
	@RequestMapping("part1_ch05/doD")
	public String doD() {
	
		// redirect의 경우 return type을 String으로 설정
		// doE.jsp로 리다이렉트 됨
		
//		return "/aprt1_ch05/doE"; // <= forward
		return "redirect:/part1_ch05/doE"; // <= redirect
	}
	
	@RequestMapping("part1_ch05/doE")
	public void doE() {
		log.info("doE() ") ;
	}
	

}
