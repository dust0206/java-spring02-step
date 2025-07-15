package com.example.spring02.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring02.board.model.dto.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Override
	public void create(BoardVO vo) throws Exception {
		log.info("# create #");
		
		sqlSession.insert("board.insert", vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		log.info("# read #");
		
		return sqlSession.selectOne("board.view", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		log.info("# update #");
		
		sqlSession.update("board.updateArticle", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		log.info("# delete #");
		
		sqlSession.delete("board.deleteArticle", bno);
	}

	@Override
	public List<BoardVO> listAll(String search_option, String keyword) throws Exception {
		log.info("# listAll #");
		Map<String, String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		return  sqlSession.selectList("board.listAll", map);
	}

	@Override
	public void increaseViewCount(int bno) throws Exception {
		log.info("# increaseViewCount #");

		sqlSession.update("board.increaseViewCount", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		log.info("# increaseViewCount #");
		Map<String, String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne("board.countArticle", map);
	}
	
	

}
