package com.funweb.service;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.domain.comment;

public interface BoardService {

	int getBoardCount(String category);
	void writeBoard(BoardBean bb);
	List<BoardBean> getBoardList(PageBean pb);
	BoardBean getBoard(BoardBean bb);
	void updateBoard(BoardBean bb);
	void deleteBoard(BoardBean bb);
	void updateReadCount(BoardBean bb);
	void recommandBoard(BoardBean bb);
	void writeComment(comment comment);
	List<comment> getCommentList(BoardBean bb);
	List<BoardBean> getHotRecipeList();
	List<BoardBean> getNoticeList();
	List<BoardBean> getPictureList();
	List<BoardBean> getBoardSearchList(PageBean pb);

}
