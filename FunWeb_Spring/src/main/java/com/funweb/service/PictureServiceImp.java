package com.funweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.NoticeDAO;
import com.funweb.dao.PictureDAO;
import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

@Repository
public class PictureServiceImp implements PictureService{

	@Inject
	private PictureDAO pictureDAO;
	
	@Override
	public int getBoardCount( ) {
		return pictureDAO.getBoardCount();
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// 시작하는 행번호 구하기 
		// int currentPage=Integer.parseInt(pageNum);
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		// int startRow= ((currentPage-1)*pageSize+1)-1;
		pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
		// int endRow=currentPage*pageSize;
		pb.setEndRow(pb.getCurrentPage()*pb.getPageSize());
		return pictureDAO.getBoardList(pb);
	}

	@Override
	public void writeBoard(BoardBean bb) {
		
		if(pictureDAO.getMaxNum() == null) {
			bb.setNum(1);			
		} else {
			bb.setNum(pictureDAO.getMaxNum() + 1);
		}
		System.out.println(bb.getNum());
		
		pictureDAO.writeBoard(bb);
		
	}

	@Override
	public BoardBean getBoard(int num) {
		return pictureDAO.getBoard(num);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		pictureDAO.updateBoard(bb);
	}

	@Override
	public void deleteBoard(int num) {
		pictureDAO.deleteBoard(num);
	}

}
