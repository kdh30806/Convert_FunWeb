package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberBean;

public interface MemberDAO {

	public void insertMember(MemberBean mb);

	public MemberBean userCheck(MemberBean mb);

	public MemberBean getMember(String id);

	public void updateMember(MemberBean mb);

	public void deleteMember(MemberBean mb);

	public List<MemberBean> getMemberList();

}
