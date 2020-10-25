package com.funweb.service;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

public interface RecipeService {

	int getBoardCount();
	void writeBoard(BoardBean bb);
	List<BoardBean> getBoardList(PageBean pb);
	BoardBean getBoard(int num);
	void updateBoard(BoardBean bb);
	void deleteBoard(int num);

}
