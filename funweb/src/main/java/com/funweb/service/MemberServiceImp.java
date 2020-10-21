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
}
