package com.example.spring02.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring02.board.model.dao.BoardDAO;
import com.example.spring02.board.model.dto.BoardVO;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO; 
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public List<BoardVO> listAll(String search_option, String keyword) throws Exception {
		log.info("# listAll() #");
		return boardDAO.listAll(search_option, keyword);
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		log.info("# create() #");
		// 태그 문자 처리 * < => &lt;, > => &gt; 
		String title = vo.getTitle();
		// replace(A,B) A를 B로 변경
		title = title.replace("<", "&lt;");
		title = title.replace(">", "&gt;");
		
		String writer = vo.getWriter();
		writer = writer.replace("<", "&lt;");
		writer = writer.replace(">", "&gt;");
		
		// 공백 문자 처리(공백 =>&nbsp; )
		title = title.replace("  ","&nbsp;&nbsp;");
		writer = writer.replace("  ","&nbsp;&nbsp;");
		
		// 줄바꿈 문자 처리 ( \n => <br>
		String content = vo.getContent();
		content = content.replace("\n", "<br>");
		vo.setContent(content);
		
		vo.setTitle(title);
		vo.setWriter(writer);;
		
		boardDAO.create(vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		log.info("# read() #");

		return boardDAO.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		log.info("# update() #");
		
		boardDAO.update(vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		log.info("# delete() #");
		
		boardDAO.delete(bno);
		
	}

	@Override
	public void increaseViewCount(int bno, HttpSession session) throws Exception {
		log.info("# increaseViewCount() #");
		
		// 세션에 저장된 조회 시간 검색
		long update_time = 0;
		if(session.getAttribute("update_time_"+bno) != null) {
			update_time = (long) session.getAttribute("update_time_" + bno);
		}
		
		// 시스템의 현재 시간
		long current_time = System.currentTimeMillis();
		// 일정 시간이 경과 후 조회수 증가 처리
		if(current_time - update_time > 5*1000) {
			boardDAO.increaseViewCount(bno);
			session.setAttribute("update_time_"+bno, current_time);
		}
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		log.info("# countArticle() #");
		
		return boardDAO.countArticle(search_option, keyword);
	}
	
	

	
}
