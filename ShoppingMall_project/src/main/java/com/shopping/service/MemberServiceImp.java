package com.shopping.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shopping.dao.MemberDAO;

@Repository
public class MemberServiceImp implements MemberService{
	
	@Inject
	private MemberDAO MemberDAO;
}
