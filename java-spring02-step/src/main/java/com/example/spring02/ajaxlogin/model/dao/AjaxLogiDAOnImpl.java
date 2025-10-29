package com.example.spring02.ajaxlogin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring02.ajaxlogin.service.AjaxLoginService;

@Repository
public class AjaxLogiDAOnImpl implements AjaxLoginDAO {

	public static final Logger log = LoggerFactory.getLogger(AjaxLoginService.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public String checkId(String id) {
		// TODO Auto-generated method stub
		log.info("dao.checkId");
		sqlSession.selectOne("checkid",id);
		return sqlSession.selectOne("checkid",id);
	}
}
