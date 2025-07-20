package com.example.spring02.login.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring02.login.model.dao.LoginDAO;
import com.example.spring02.login.model.dao.LoginDAOImpl;
import com.example.spring02.login.model.dto.LoginVO;

// 현재 클래스를 스프링에서 관리하는 서비스 bean으로 등록
@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDao;
	
	private static final Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);

	@Override
	public boolean loginCheck(LoginVO vo, HttpSession session) {
		log.info("# loginCheck() #");
		boolean result = loginDao.loginCheck(vo);
		if(result) {	// true일 경우 세션 등록
			LoginVO vo2 = viewLogin(vo);
			// 세션 변수 등록
			session.setAttribute("userid", vo2.getUserid());
			session.setAttribute("username", vo2.getUsername());
			
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		log.info("# logout() #");
		// 세션변수 개별 삭제 할때
		// session.removeAttribute("userid");
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}

	@Override
	public LoginVO viewLogin(LoginVO vo) {
		log.info("# viewLogin() #");
		return loginDao.viewLogin(vo);
	}
	
	
}
