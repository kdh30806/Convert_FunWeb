package com.shopping.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shopping.dao.MemberDAO;
import com.shopping.domain.MemberBean;

@Repository
public class MemberServiceImp implements MemberService{
	
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberBean mb) {
		int mem_num = 0;
		
		if(memberDAO.getMaxNum() == null) {
			mem_num = 0;
		} else {
			mem_num = memberDAO.getMaxNum();
		}
		mb.setMem_num(mem_num);
		mb.setMobile(mb.getMobile1() + mb.getMobile2() + mb.getMobile3() );
		mb.setPhone(mb.getPhone1() + mb.getPhone2() + mb.getPhone3());
		mb.setBirth(mb.getYear() + "년" + mb.getMonth() + "월" + mb.getDay() + "일");		
		memberDAO.insertMember(mb);
	}
}
