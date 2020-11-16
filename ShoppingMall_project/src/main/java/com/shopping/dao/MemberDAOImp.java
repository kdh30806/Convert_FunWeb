package com.shopping.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shopping.domain.MemberBean;

@Repository
public class MemberDAOImp implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.shopping.mappers.memberMapper";

	@Override
	public void insertMember(MemberBean mb) {
		sqlSession.insert(namespace+".insertMember",mb);
	}

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace+".getMaxNum");
	}

}
