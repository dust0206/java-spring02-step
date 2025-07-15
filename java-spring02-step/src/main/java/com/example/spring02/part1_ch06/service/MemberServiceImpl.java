package com.example.spring02.part1_ch06.service;



import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring02.part1_ch06.model.dao.MemberDAO;
import com.example.spring02.part1_ch06.model.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
		
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	MemberDAO memberDao;

	@Override
	public List<MemberVO> memberList() {
		log.info("# memberList() #");
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberVO vo) {
		log.info("# insertMember() #");
		// TODO Auto-generated method stub
		memberDao.insertMember(vo);
	}

	@Override
	public MemberVO viewMember(String userid) {
		log.info("# viewMember() #");
		// TODO Auto-generated method stub
		return memberDao.viewMember(userid);
	}


	@Override
	public void updateMember(MemberVO vo) {
		log.info("# updateMember() #");
		// TODO Auto-generated method stub
		log.info("# vo #"+vo);
		memberDao.updateMember(vo);
	}
	
	@Override
	public void deleteMember(String userid) {
		log.info("# deleteMember() #");
		// TODO Auto-generated method stub
		memberDao.deleteMember(userid);
		
	}

	@Override
	public boolean checkPw(String userid, String userpw) {
		log.info("# checkPw() #");
		// TODO Auto-generated method stub
		
		return memberDao.checkPw(userid, userpw);
	}
}
