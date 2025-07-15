package com.example.spring02.part1_ch06.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring02.part1_ch06.model.dto.MemberVO;
import com.example.spring02.part1_ch06.service.MemberService;
import com.example.spring02.part1_ch06.service.MemberServiceImpl;

@Controller		// 현재 클래스를 controller bean으로 등록시킴
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	// MemberService 객체를 스프링에서 생성하여 주입시킴
	@Inject
	MemberService memberService;
	
	// url pattern mapping
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		log.info("## memberList() ### ");
		
		// Controller => Server => DAO 요청
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	// 회원 등록폼으로 이동
	@RequestMapping("member/insertForm.do")
	public String insertForm() {
		log.info("## insertForm() ### ");
		return "member/insertForm";
	}
	
	// insert 처리
	@RequestMapping("member/insert.do")
	// @ModelAttribute : 
	// Model - 데이터 저장소
	// Attribute - 속성 값들
	public String insert(@ModelAttribute MemberVO vo) {

		//	public String insert(HttpServletRequest request) {
//		String userid = request.getParameter("userid");

//	public String insert(String userid, String userpw, String username, String email) {
		log.info("## insert() ### ");
		log.info("## MemberVO vo ### " + vo);
		
		// 테이블에 레코드를 입력
		memberService.insertMember(vo);
		
		// member_list.jsp로 리다이렉트
		// /member/list.do : 루트 디렉토리 기준
		// member/list.do 현재 디렉토리 기준
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("member/view.do")
	public String view(@RequestParam(required = true, value = "userid") String userid, Model model) {
		// info, debug, warn, error
		log.info(" # view() #");
		log.info("userid : "+ userid);
		
		// 회원 정보를 모델에 저장
		model.addAttribute("dto", memberService.viewMember(userid));
		
		// view.jsp로 포워딩
		return "member/view";
	}
	
	@RequestMapping("member/update.do")
	public String update(@ModelAttribute MemberVO vo, Model model) {
		log.info(" # update() #");
		
		// 비밀번호 체크
		boolean result = memberService.checkPw(vo.getUserid(), vo.getUserpw()) ;
		if(result) {
			memberService.updateMember(vo);
			return "redirect:/member/list.do";
		} else {
			// 가입일자, 수정날짜 가져오기
			MemberVO vo2 = memberService.viewMember(vo.getUserid());
			vo.setRegdate(vo2.getRegdate());
			vo.setUpdatedate(vo2.getUpdatedate());
			
			model.addAttribute("dto", vo);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다");
			return "member/view";
		}
		
	}
	
	// @RequestMapping : url mapping
	// @RequestParam : get 또는 post방식으로 전달된 변수값
	// @ModelAttribute : 객체 형식으로 전달된 값
	
	@RequestMapping("member/delete.do")
	public String delete(@RequestParam String userid, @RequestParam  String userpw, Model model) {
		log.info(" # delete() #");
		
		// 비밀번호 체크
		boolean result = memberService.checkPw(userid, userpw) ;
		if(result) {
			// 삭제처리
			memberService.deleteMember(userid);
			// 회원 목록으로 이동
			return "redirect:/member/list.do";
			
		} else {
			// 비밀번호가 틀렸을 때
			model.addAttribute("message","비미번호가 일치하지 않습니다");
			model.addAttribute("dto", memberService.viewMember(userid));
			// view.jsp로 이동
			return "member/view";
		}
		
	}
	
}
