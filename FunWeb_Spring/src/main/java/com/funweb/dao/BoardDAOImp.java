package com.funweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

@Repository
public class BoardDAOImp implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	String namespace = "com.funweb.mappers.noticeMapper";
	
	@Override
	public Integer getNoticeMaxNum( ) {
		return sqlSession.selectOne(namespace+".getNoticeMaxNum");
	}
	
	@Override
	public int getNoticeCount( ) {
		return sqlSession.selectOne(namespace+".getNoticeCount");
	}
	
	@Override
	public void writeNotice(BoardBean bb) {
		sqlSession.insert(namespace+".writeNotice",bb);
	}

	@Override
	public List<BoardBean> getNoticeList(PageBean pb) {
		return sqlSession.selectList(namespace+".getNoticeList",pb);
	}

	@Override
	public BoardBean getNotice(int num) {
		return sqlSession.selectOne(namespace+".getNotice",num);
	}

	@Override
	public void updateNotice(BoardBean bb) {
		sqlSession.update(namespace+".updateNotice",bb);
	}

	@Override
	public void deleteNotice(int num) {
		sqlSession.delete(namespace+".deleteNotice",num);
	}
}
