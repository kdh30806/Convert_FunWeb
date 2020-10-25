package com.funweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

@Repository
public class RecipeDAOImp implements RecipeDAO{

	@Inject
	private SqlSession sqlSession;
	String namespace = "com.funweb.mappers.recipeMapper";
	
	@Override
	public Integer getMaxNum( ) {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}
	
	@Override
	public int getBoardCount( ) {
		return sqlSession.selectOne(namespace+".getBoardCount");
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
	public BoardBean getBoard(int num) {
		return sqlSession.selectOne(namespace+".getBoard",num);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		sqlSession.update(namespace+".updateBoard",bb);
	}

	@Override
	public void deleteBoard(int num) {
		sqlSession.delete(namespace+".deleteBoard",num);
	}
}
