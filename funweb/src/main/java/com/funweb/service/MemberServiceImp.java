package com.funweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.MemberDAO;

@Repository
public class MemberServiceImp implements MemberService{

	@Inject
	private MemberDAO memberDAO;
}
