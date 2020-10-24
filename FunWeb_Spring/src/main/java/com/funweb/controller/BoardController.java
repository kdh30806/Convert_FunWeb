package com.funweb.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.funweb.domain.BoardBean;
import com.funweb.domain.PageBean;
import com.funweb.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/board/notice/noticeMain", method = RequestMethod.GET)
	public String noticeMain(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		if(pageNum == null) {
			pb.setPageNum("1");
		}
		pb.setPageNum(pageNum);
		
		List<BoardBean> noticeList = boardService.getNoticeList(pb);
		
		pb.setCount(boardService.getNoticeCount());
		
		session.setAttribute("id", id);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pb", pb);
		
		return "/board/notice/noticeMain";
	}
	
	@RequestMapping(value = "/board/notice/noticeWrite", method = RequestMethod.GET)
	public String noticeWrite(HttpSession session) {	
		
		String id = (String)session.getAttribute("id");
		session.setAttribute("id", id);
		
		return "/board/notice/noticeWrite";
	}
	
	@RequestMapping(value = "/board/notice/noticeWrite", method = RequestMethod.POST)
	public String noticeWritePost(BoardBean bb) {	
		
		boardService.writeNotice(bb);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/board/notice/content", method = RequestMethod.GET)
	public String content(HttpSession session, HttpServletRequest request) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = boardService.getNotice(num);
		
		session.setAttribute("id", id);		
		return "/board/notice/content";
	}

}
