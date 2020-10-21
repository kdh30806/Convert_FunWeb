package com.funweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.BoardDAO;
import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

@Repository
public class BoardServiceImp implements BoardService{

	@Inject
	private BoardDAO boardDAO;

	@Override
	public int getBoardCount() {
		return boardDAO.getBoardCount();
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// TODO Auto-generated method stub
		return null;
	}
}
