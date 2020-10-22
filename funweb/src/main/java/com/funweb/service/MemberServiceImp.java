package com.funweb.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.MemberDAO;
import com.funweb.domain.MemberBean;

@Repository
public class MemberServiceImp implements MemberService{

	@Inject
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberBean mb) {
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		memberDAO.insertMember(mb);
	}

	@Override
	public MemberBean loginMember(MemberBean mb) {
		return memberDAO.loginMember(mb);
	}

	@Override
	public MemberBean getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberBean mb) {
		memberDAO.updateMember(mb);
	}

	
	@Override
	public MemberBean checkPass(MemberBean mb) {
		return memberDAO.checkPass(mb);
	}
}
