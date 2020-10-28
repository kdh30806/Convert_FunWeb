package com.funweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.BoardDAO;
import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.domain.comment;

@Repository
public class BoardServiceImp implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	@Override
	public int getBoardCount(String category) {
		return boardDAO.getBoardCount(category);
	}

	@Override
	public List<BoardBean> getBoardList(PageBean pb) {
		// 시작하는 행번호 구하기
		// int currentPage=Integer.parseInt(pageNum);
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		// int startRow= ((currentPage-1)*pageSize+1)-1;
		pb.setStartRow((pb.getCurrentPage() - 1) * pb.getPageSize());
		// int endRow=currentPage*pageSize;
		pb.setEndRow(pb.getCurrentPage() * pb.getPageSize());
		return boardDAO.getBoardList(pb);
	}

	@Override
	public void writeBoard(BoardBean bb) {

		if (boardDAO.getMaxNum(bb.getCategory()) == null) {
			bb.setNum(1);
		} else {
			bb.setNum(boardDAO.getMaxNum(bb.getCategory()) + 1);
		}

		boardDAO.writeBoard(bb);

	}

	@Override
	public BoardBean getBoard(BoardBean bb) {
		return boardDAO.getBoard(bb);
	}

	@Override
	public void updateBoard(BoardBean bb) {
		boardDAO.updateBoard(bb);
	}

	@Override
	public void deleteBoard(BoardBean bb) {
		boardDAO.deleteBoard(bb);
	}

	@Override
	public void updateReadCount(BoardBean bb) {
		boardDAO.updateReadCount(bb);
	}

	@Override
	public void recommandBoard(BoardBean bb) {
		boardDAO.recommandBoard(bb);
	}

	@Override
	public void writeComment(comment comment) {

		if (boardDAO.getMaxNum(comment.getCategory()) == null) {
			comment.setNum(1);
		} else {
			comment.setNum(boardDAO.getMaxNum(comment.getCategory()) + 1);
		}

		boardDAO.wrtieComment(comment);
	}

	@Override
	public List<comment> getCommentList(BoardBean bb) {
		return boardDAO.getCommentList(bb);
	}

	@Override
	public List<BoardBean> getHotRecipeList() {
		return boardDAO.getHotRecipeList();
	}

	@Override
	public List<BoardBean> getNoticeList() {
		return boardDAO.getNoticeList();
	}

	@Override
	public List<BoardBean> getPictureList() {
		return boardDAO.getPictureList();
	}

	@Override
	public List<BoardBean> getBoardSearchList(PageBean pb) {
		// 시작하는 행번호 구하기
		// int currentPage=Integer.parseInt(pageNum);
		pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
		// int startRow= ((currentPage-1)*pageSize+1)-1;
		pb.setStartRow((pb.getCurrentPage() - 1) * pb.getPageSize());
		// int endRow=currentPage*pageSize;
		pb.setEndRow(pb.getCurrentPage() * pb.getPageSize());
		
		return boardDAO.getBoardSearchList(pb);
	}

}
