package com.example.spring02.part1_ch06.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring02.part1_ch06.model.dto.MemberVO;

// 현재 클래스를 dao bean으로 등록시킴
// @Repository로 만들면 싱글톤으로 객체를 자동으로 만들어서 올라온다
@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	
	// SqlSession 객체를 스프링에 생성하여 주입시켜줌
	// 의존관계 주입(Dependency Injection, DI)
	// 느슨한 결합
	// IoC(Inversion of Control, 제어의 역전)
	@Inject		// 주사, 주입
	SqlSession sqlSession;
	
	
	@Override
	public List<MemberVO> memberList() {
		log.info("# memberList() #");
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberVO vo) {
		log.info("# insertMember() #");
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertMember", vo);
		
	}

	@Override
	public MemberVO viewMember(String userid) {
		log.info("# viewMember() #");
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember", userid);
	}


	@Override
	public void updateMember(MemberVO vo) {
		log.info("# updateMember() #");
		// TODO Auto-generated method stub
		log.info("--- vo --- " + vo);
		sqlSession.update("member.updateMember", vo);
	}

	@Override
	public void deleteMember(String userid) {
		log.info("# deleteMember() #");
		// TODO Auto-generated method stub
		sqlSession.delete("member.deleteMember",userid);
	}

	@Override
	public boolean checkPw(String userid, String userpw) {
		log.info("# checkPw() #");
		// TODO Auto-generated method stub
		boolean result = false;
		
		Map<String,String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		
		int count = sqlSession.selectOne("member.checkPw",map);
		if(count == 1) {
			result = true;
		}
		
		return result;
	}
}
