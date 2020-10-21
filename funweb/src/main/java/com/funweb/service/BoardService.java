package com.funweb.service;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

public interface BoardService {

	int getBoardCount();
	List<BoardBean> getBoardList(PageBean pb);

}
