package com.example.spring02.login.model.dao;


import com.example.spring02.login.model.dto.LoginVO;

public interface LoginDAO {
	
	public boolean loginCheck(LoginVO vo);
	public LoginVO viewLogin(LoginVO vo);
}
