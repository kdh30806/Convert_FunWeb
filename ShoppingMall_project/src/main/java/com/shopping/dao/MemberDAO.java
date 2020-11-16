package com.shopping.dao;

import com.shopping.domain.MemberBean;

public interface MemberDAO {

	void insertMember(MemberBean mb);
	Integer getMaxNum();
}
