package com.shopping.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class memberDAOImp implements memberDAO{
	
	@Inject
	private SqlSession sqlSession;

}
