package com.example.spring02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

// 콘트롤러 어노테이션
@Controller
public class HomeController {
	// 로깅툴 설정
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// 시작 페이지로 이동
	@RequestMapping("/")
	public String main(Model model) {
		log.info("### main() ###" );
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		
		// /WEB-INF/views/main.jsp
		return "main";	// main.jsp로 포워딩 됨
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		// 모델(서블릿의 request 객체 대체)
		model.addAttribute("serverTime", formattedDate );
		
		// home.jsp로 포워딩
//		<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//			<beans:property name="prefix" value="/WEB-INF/views/" />
//			<beans:property name="suffix" value=".jsp" />
//		</beans:bean>
//		return "/WEB-INF/views/home.jsp";
		return "home";
	}
	
}
