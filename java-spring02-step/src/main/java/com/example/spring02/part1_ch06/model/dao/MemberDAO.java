package com.example.spring02.part1_ch06.model.dao;

import java.util.List;

import com.example.spring02.part1_ch06.model.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberVO vo);
	public boolean checkPw(String userid, String userpw);
}
