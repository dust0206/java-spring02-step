package com.example.spring02.ajaxlogin.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring02.ajaxlogin.model.dao.AjaxLoginDAO;

@Service
public class AjaxLoginServiceImpl implements AjaxLoginService {

	public static final Logger log = LoggerFactory.getLogger(AjaxLoginService.class);
	
	@Inject
	private AjaxLoginDAO dao;
	
	@Override
	public String checkId(String id) {
		// TODO Auto-generated method stub
		log.info("service.checkId");
		dao.checkId(id);
		return dao.checkId(id);
	}

}
