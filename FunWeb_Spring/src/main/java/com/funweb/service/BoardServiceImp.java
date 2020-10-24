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
		// 시작하는 행번호 구하기 
		// int currentPage=Integer.parseInt(pageNum);
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		// int startRow= ((currentPage-1)*pageSize+1)-1;
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
		// int endRow=currentPage*pageSize;
		pb.setEndRow(pb.getCurrentPage()*pb.getPageSize());
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

	@Override
	public void updateNotice(BoardBean bb) {
		boardDAO.updateNotice(bb);
	}

	@Override
	public void deleteNotice(int num) {
		boardDAO.deleteNotice(num);
	}

}
