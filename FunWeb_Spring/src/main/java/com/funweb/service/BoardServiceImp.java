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
	public int getNoticeCount( ) {
		return boardDAO.getNoticeCount();
	}

	@Override
	public List<BoardBean> getNoticeList(PageBean pb) {
		return boardDAO.getNoticeList(pb);
	}

	@Override
	public void writeNotice(BoardBean bb) {
		
		if(boardDAO.getNoticeMaxNum() == null) {
			bb.setNum(1);			
		} else {
			bb.setNum(boardDAO.getNoticeMaxNum() + 1);
		}
		System.out.println(bb.getNum());
		
		boardDAO.writeNotice(bb);
		
	}

	@Override
	public BoardBean getNotice(int num) {
		return boardDAO.getNotice(num);
	}

}
