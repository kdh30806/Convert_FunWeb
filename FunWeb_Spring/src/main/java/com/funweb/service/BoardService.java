package com.funweb.service;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

public interface BoardService {

	int getNoticeCount();
	void writeNotice(BoardBean bb);
	List<BoardBean> getNoticeList(PageBean pb);
	BoardBean getNotice(int num);
	void updateNotice(BoardBean bb);
	void deleteNotice(int num);

}
