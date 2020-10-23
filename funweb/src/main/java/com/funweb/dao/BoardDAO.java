package com.funweb.dao;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

public interface BoardDAO {

	int getNoticeCount();
	
	Integer getNoticeMaxNum();

	void writeNotice(BoardBean bb);

	List<BoardBean> getNoticeList(PageBean pb);

	BoardBean getNotice(int num);

}
