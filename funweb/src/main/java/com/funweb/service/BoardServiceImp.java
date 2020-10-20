package com.funweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.BoardDAO;

@Repository
public class BoardServiceImp {

	@Inject
	private BoardDAO boardDAO;
}
