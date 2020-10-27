package com.funweb.dao;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.domain.comment;

public interface BoardDAO {

	int getBoardCount(String category);
	
	Integer getMaxNum(String category);

	void writeBoard(BoardBean bb);

	List<BoardBean> getBoardList(PageBean pb);

	BoardBean getBoard(BoardBean bb);

	void updateBoard(BoardBean bb);

	void deleteBoard(BoardBean bb);

	void updateReadCount(BoardBean bb);

	void recommandBoard(BoardBean bb);

	void wrtieComment(comment comment);

	List<comment> getCommentList(BoardBean bb);

	List<BoardBean> getHotRecipeList();

}
