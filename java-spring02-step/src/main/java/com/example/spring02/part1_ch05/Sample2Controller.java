package com.example.spring02.part1_ch05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


// ajax 처리 전용 콘트롤러 (백그라운에서 실행됨)
@RestController	// 스프링 4.0이상부터 사용가능
public class Sample2Controller {

	@RequestMapping("part1_ch05/doF")
	public @ResponseBody ProductVO doF() {
	//	@ResponseBody : json 형식으로 데이터를 리턴
		
		// doF.jsp로 json 데이터가 리턴됨
		return new ProductVO("냉장고", 500000);
	}
}
