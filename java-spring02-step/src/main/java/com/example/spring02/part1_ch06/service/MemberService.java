package com.example.spring02.part1_ch06.service;

import java.util.List;

import com.example.spring02.part1_ch06.model.dto.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberVO vo);
	
	// 비밀번호 체크
	public boolean checkPw(String userid, String userpw);
}
