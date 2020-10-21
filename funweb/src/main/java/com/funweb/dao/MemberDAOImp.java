package com.funweb.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.funweb.domain.MemberBean;

@Repository
public class MemberDAOImp implements MemberDAO{

	// MyBatis 디비 연동 자동주입 객체 생성
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.funweb.mappers.memberMapper";
	
	@Override
	public void insertMember(MemberBean mb) {
		System.out.println("MemberDAOImpl - insertMember");
		sqlSession.insert(namespace+".insertMember",mb);
	}
	
}
