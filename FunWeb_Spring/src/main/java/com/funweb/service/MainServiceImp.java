package com.funweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.MainDAO;
import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

@Repository
public class MainServiceImp implements MainService{

	@Inject
	private MainDAO mainDAO;

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		
		return null;
	}
}
