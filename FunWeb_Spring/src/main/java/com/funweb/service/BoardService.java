package com.funweb.service;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

public interface BoardService {

	int getBoardCount(String category);
	void writeBoard(BoardBean bb);
	List<BoardBean> getBoardList(PageBean pb);
	BoardBean getBoard(BoardBean bb);
	void updateBoard(BoardBean bb);
	void deleteBoard(BoardBean bb);

}
