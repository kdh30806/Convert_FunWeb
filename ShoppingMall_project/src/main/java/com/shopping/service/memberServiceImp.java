package com.shopping.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shopping.dao.memberDAO;

@Repository
public class memberServiceImp implements memberService{
	
	@Inject
	private memberDAO memberDAO;
}
