package com.funweb.service;

import java.util.List;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;

public interface MainService {

	List<BoardBean> getBoardList(PageBean pb);

}
