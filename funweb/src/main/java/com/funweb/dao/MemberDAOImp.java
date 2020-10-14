package com.funweb.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImp implements MemberDAO{

	// MyBatis 디비 연동 자동주입 객체 생성
	@Inject
	private SqlSession sqlSession;
	String namespace = "com.funweb.mapper.memberMapper";
	
}
