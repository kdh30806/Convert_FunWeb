package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardBean;
import com.itwillbs.domain.PageBean;

public interface BoardDAO {
	public void insertBoard(BoardBean bb);
	public Integer getMaxNum();
	public List<BoardBean> getBoardList(PageBean pb);
	public Integer getBoardCount();
	void updateReseq(BoardBean bb);
	BoardBean getBoard(int num);
	BoardBean numCheck(BoardBean bb);
	void updateBoard(BoardBean bb);
	void deleteBoard(BoardBean bb);
}
