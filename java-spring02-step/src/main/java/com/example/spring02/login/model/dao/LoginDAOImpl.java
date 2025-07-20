package com.example.spring02.login.model.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring02.login.model.dto.LoginVO;

// 현재 클래스를 스프링에서 관리하는 dao bean으로 등록
@Repository
public class LoginDAOImpl implements LoginDAO {

	// SqlSession 객체를 스프링에서 생성하여 주입시킴
	// 의존관계 주입(Dependency Injection), 느슨한 결합
	@Inject
	private SqlSession sqlSession;	// mybatis 실행 객체
	
	private static final Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);
	
	@Override
	public boolean loginCheck(LoginVO vo) {
		log.info("# login() #");
		
		String name = sqlSession.selectOne("login.login_check",vo);
		
		return (name == null) ? false : true;
	}

	@Override
	public LoginVO viewLogin(LoginVO vo) {
		log.info("# viewLogin() #");
		 
		return sqlSession.selectOne("login.viewLogin", vo);
	}

}
