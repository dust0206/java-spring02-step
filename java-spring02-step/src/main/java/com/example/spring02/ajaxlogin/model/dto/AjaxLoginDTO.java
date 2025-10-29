package com.example.spring02.ajaxlogin.model.dto;

import java.sql.Date;

public class AjaxLoginDTO {
	private String id;  
	private String pw;  
	private String name;  
	private String gender;   
	private Date birth;          
	private String tel;  
	private String email;  
	private Date regdate;          
	private Date condate;          
	private String status;   
	private String photo; 
	private int newmsgcnt;        
	private int grandno;
	
	public AjaxLoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getCondate() {
		return condate;
	}

	public void setCondate(Date condate) {
		this.condate = condate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getNewmsgcnt() {
		return newmsgcnt;
	}

	public void setNewmsgcnt(int newmsgcnt) {
		this.newmsgcnt = newmsgcnt;
	}

	public int getGrandno() {
		return grandno;
	}

	public void setGrandno(int grandno) {
		this.grandno = grandno;
	}
	
	
}
