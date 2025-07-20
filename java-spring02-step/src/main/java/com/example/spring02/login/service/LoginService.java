package com.example.spring02.login.service;

import javax.servlet.http.HttpSession;

import com.example.spring02.login.model.dto.LoginVO;


public interface LoginService {

	public boolean loginCheck(LoginVO vo, HttpSession session);
	public LoginVO viewLogin(LoginVO vo);
	public void logout(HttpSession session);

}
