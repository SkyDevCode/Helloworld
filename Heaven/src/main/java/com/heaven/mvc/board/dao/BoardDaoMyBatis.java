package com.heaven.mvc.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heaven.mvc.board.domain.BoardVO;

@Repository
public class BoardDaoMyBatis implements BoardDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public int delete(BoardVO boardVO) {
		return sqlSessionTemplate.delete("delte", boardVO);
	}
	
	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("deleteAll");
	}

	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("update", boardVO);
	}

	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insert", boardVO);
	}

	@Override
	public BoardVO selsect(int seq) {
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("select", seq);
		return vo;
	}

	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}

}
