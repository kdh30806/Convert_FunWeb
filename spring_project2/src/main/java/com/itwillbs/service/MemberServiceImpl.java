package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberBean;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberBean mb) {
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		memberDAO.insertMember(mb);
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		MemberBean mb2 = memberDAO.userCheck(mb);
		return mb2;
	}

	@Override
	public MemberBean getMember(String id) {
		MemberBean mb = memberDAO.getMember(id);
		return mb;
	}

	@Override
	public void updateMember(MemberBean mb) {
		memberDAO.updateMember(mb);
	}

	@Override
	public void deleteMember(MemberBean mb) {
		memberDAO.deleteMember(mb);	
	}

	@Override
	public List<MemberBean> getMemberList() {
		return memberDAO.getMemberList();
	}

}
