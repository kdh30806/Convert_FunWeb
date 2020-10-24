package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardService {
	public void insertBoard(BoardBean bb);
	public List<BoardBean> getBoardList(PageBean pb);
	public Integer getBoardCount();
	BoardBean getBoard(int num);
	BoardBean numCheck(BoardBean bb);
	void updateBoard(BoardBean bb);
	void deleteBoard(BoardBean bb);
	void reInsertBoard(BoardBean bb);
}
