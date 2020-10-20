package com.funweb.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImp implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	String namespace = "com.funweb.mapper.boardMapper";
}
