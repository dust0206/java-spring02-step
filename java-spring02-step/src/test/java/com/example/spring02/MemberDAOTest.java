package com.example.spring02;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.spring02.part1_ch06.model.dao.MemberDAO;
import com.example.spring02.part1_ch06.model.dto.MemberVO;

// JUnit : 테스트 자동화 도구
// 테스트할 클래스 이름 + Test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MemberDAOTest {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class) ;
	
	// MemberDAOImpl 크래스가 생성되어 주입됨
	@Inject
	MemberDAO dao;
	
	@Test
	public void testMemberList() {
		log.info("### 회원목록 : ###" + dao.memberList());
	}

	@Test
	public void testInsertMember() {
		log.info("testInsertMember() ");
		MemberVO vo = new MemberVO();
		vo.setUserid("user01");
		vo.setUserpw("user00");
		vo.setUsername("user00");
		vo.setEmail("user00@aaa.com");
		
		dao.insertMember(vo);
		
	}

	@Test
	public void testViewMember() {
		log.info("### DTO : ### "+dao.viewMember("kim"));
	}

	@Test
	public void testUpdateMember() {
		log.info("회원 수정");
		MemberVO vo = new MemberVO();
		vo.setUserid("user01");
		vo.setUserpw("user01");
		vo.setUsername("user01");
		vo.setEmail("user01@aaa.com");
		
		dao.updateMember(vo);
		
	}

	@Test
	public void testDeleteMember() {
		log.info("회원 삭제");
		dao.deleteMember("1");
	}

	@Test
	public void testCheckPw() {
		log.info("비밀번호 체크 : " + dao.checkPw("kim", "1234"));
		log.info("비밀번호 체크 : " + dao.checkPw("kim", "2222"));
	}

}
