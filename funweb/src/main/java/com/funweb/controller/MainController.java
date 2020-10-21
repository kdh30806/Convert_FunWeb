package com.funweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.service.BoardService;
import com.funweb.service.MainService;

@Controller
public class MainController {
	
	@Inject
	private MainService mainService;
	
	@Inject 
	private BoardService boardService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		
//		PageBean pb = new PageBean();
//		
//		//한페이지에 보여줄 글 갯수
//		pb.setPageSize(5);
//		//URL 페이지 번호 설정 => 메인페이지라서 1로 기본설정
//		pb.setPageNum("1");
//		//전체 페이지 글 갯수
//		pb.setCount(boardService.getBoardCount());
//		
//		List<BoardBean> boardList_notice=boardService.getBoardList(pb);
		
		return "main";
	}

}
