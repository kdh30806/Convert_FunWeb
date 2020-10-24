package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.itwillbs.mappers.memberMapper";
	
	
	@Override
	public void insertMember(MemberBean mb) {
		System.out.println("MemberDAOImpl - insertMember");
		sqlSession.insert(namespace+".insertMember",mb);
	}


	@Override
	public MemberBean userCheck(MemberBean mb) {		
		return sqlSession.selectOne(namespace+".userCheck",mb);
	}


	@Override
	public MemberBean getMember(String id) {
		return sqlSession.selectOne(namespace+".getMember", id);
	}


	@Override
	public void updateMember(MemberBean mb) {
		sqlSession.update(namespace+".updateMember",mb);
	}


	@Override
	public void deleteMember(MemberBean mb) {
		sqlSession.delete(namespace+".deleteMember",mb);
	}


	@Override
	public List<MemberBean> getMemberList() {
		return sqlSession.selectList(namespace+".getMemberList");
	}

}
