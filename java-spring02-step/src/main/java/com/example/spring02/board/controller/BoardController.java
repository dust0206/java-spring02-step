package com.example.spring02.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.board.model.dto.BoardVO;
import com.example.spring02.board.service.BoardService;


@Controller		// 현재 클래스를 콘트롤러 빈으로 등록
public class BoardController {
	
	@Inject
	BoardService boardService;  

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("board/list.do")	// /board/list.do
	// @RequestParam(defaultValue="title") - 기본값 할당
	public ModelAndView list(Model model, @RequestParam(defaultValue = "title") String search_option, @RequestParam(defaultValue="") String keyword) throws Exception {
		log.info("# list() #");
		// 레코드 갯수 계산
//		int count = boardService.countArticle(search_option, keyword);
		
		List<BoardVO> list = boardService.listAll(search_option, keyword);
		
//		model.addAttribute("list", list);
//		return "list";
		
		// 모델과 뷰
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");	// 뷰를 list.jsp로 설정
		mav.addObject("list", list);	// 데이터 저장
//		mav.addObject("count", count);	// 데이터 카운트
		mav.addObject("count", list.size());	// 데이터 카운트
		
		return mav;		// list.jsp 로 List가 전달됨
	}
	
	// @RequestMapping("board/write.do") - 기본은 RequestMethod.GET 방식이고
	// value="url이름", method="전송방식"
	@RequestMapping(value="board/write.do", method=RequestMethod.GET)
	public String write() {
		log.info("# write() #");
		
		return "board/write";	// write.jsp로 이동
	}
	
	@RequestMapping(value="board/insert.do", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo) throws Exception {
		log.info("# insert() #");
		
		boardService.create(vo);
		// 내부에서 
		return "redirect:list.do";
	}
/*
 	- 예전방식 -
	public String insert1(HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		return "redirect:board/list.do";
	}
*/	

	@RequestMapping(value="board/view.do", method = RequestMethod.GET)
	// @RequestParam : get 또는 post 방식으로 전달된 변수 (생략가능)
	 // @ModelAttribute : 객체로 저장됨
	// HttpSession : 세션 객체
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		log.info("# view() #");
		// 조회수 증가 처리
		boardService.increaseViewCount(bno, session);

		// 모델(데이터) + 뷰(화면)을 함께 전달하는 객체
		ModelAndView mav = new ModelAndView();
		// 뷰의 이름 설정
		mav.setViewName("board/view");		// board/view.jsp
		// 뷰에 전달할 데이터
		mav.addObject("vo", boardService.read(bno));
		
		return mav;
	}
/*
	- 예전방식 -
	public ModelAndView view1(HttpServletRequest request, ModelAndView mav) throws Exception {
	
		--- request로 처리 ---
		int bno = Integer.parseInt(request.getParameter("bno"));
		mav.addObject("vo", boardService.read(bno));
		
		-- session 처리 --
		Httpdsession session = request.getSession();
		
		return mav;
	}
*/
	// 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
	@RequestMapping(value="board/update.do", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo, Model model) throws Exception {
		log.info("# update() #");
		
		boardService.update(vo);
//		// 포워드 방식 - 
//		model.addAttribute("list",boardService.listAll());
//		return "board/list";
//		 리다이렉트 방식
		return "redirect: list.do";
	}
	
	@RequestMapping("board/delete.do")
	public String delete(@RequestParam int bno) throws Exception {
		log.info("# delete() #");
		// 삭제처리
		boardService.delete(bno);
		
		// 페이지 이동
		return "redirect:list.do";
	}
}
