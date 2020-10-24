package com.funweb.service;

import com.funweb.domain.MemberBean;

public interface MemberService {

	void insertMember(MemberBean mb);

	MemberBean loginMember(MemberBean mb);

	MemberBean getMember(String id);

	void updateMember(MemberBean mb);


	MemberBean checkPass(MemberBean mb);

}
