package com.funweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.domain.comment;

@Repository
public class BoardDAOImp implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	String namespace = "com.funweb.mappers.boardMapper";
	
	@Override
	public Integer getMaxNum(String category) {
		return sqlSession.selectOne(namespace+".getMaxNum",category);
	}
	
	@Override
	public int getBoardCount(String category) {
		return sqlSession.selectOne(namespace+".getBoardCount",category);
	}
	
	@Override
	public void writeBoard(BoardBean bb) {
		sqlSession.insert(namespace+".writeBoard",bb);
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		return sqlSession.selectList(namespace+".getBoardList",pb);
	}

	@Override
	public BoardBean getBoard(BoardBean bb) {
		return sqlSession.selectOne(namespace+".getBoard",bb);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		sqlSession.update(namespace+".updateBoard",bb);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		sqlSession.delete(namespace+".deleteBoard",bb);
	}

	@Override
	public void updateReadCount(BoardBean bb) {
		sqlSession.update(namespace+".updateReadCount",bb);
	}

	@Override
	public void recommandBoard(BoardBean bb) {
		sqlSession.update(namespace+".recommandBoard",bb);
	}

	@Override
	public void wrtieComment(comment comment) {
		sqlSession.insert(namespace+".writeComment",comment);
	}

	@Override
	public List<comment> getCommentList(BoardBean bb) {
		return sqlSession.selectList(namespace+".getCommentList",bb);
	}
}
