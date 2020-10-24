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
	
	@RequestMapping(value = "/board/notice/main", method = RequestMethod.GET)
	public String main(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		if(pageNum == null) {
			pageNum = "1";
		}
		pb.setPageNum(pageNum);
		
		List<BoardBean> noticeList = boardService.getNoticeList(pb);
		
		pb.setCount(boardService.getNoticeCount());
		
		session.setAttribute("id", id);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pb", pb);
		
		return "/board/notice/main";
	}
	
	@RequestMapping(value = "/board/notice/write", method = RequestMethod.GET)
	public String write(HttpSession session) {	
		
		String id = (String)session.getAttribute("id");
		session.setAttribute("id", id);
		
		return "/board/notice/write";
	}
	
	@RequestMapping(value = "/board/notice/write", method = RequestMethod.POST)
	public String writePost(BoardBean bb) {	
		
		boardService.writeNotice(bb);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/board/notice/content", method = RequestMethod.GET)
	public String content(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = boardService.getNotice(num);
		
		session.setAttribute("id", id);	
		model.addAttribute("bb", bb);
		return "/board/notice/content";
	}
	
	@RequestMapping(value = "/board/notice/update", method = RequestMethod.GET)
	public String update(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = boardService.getNotice(num);
		
		session.setAttribute("id", id);	
		model.addAttribute("bb", bb);
		return "/board/notice/update";
	}
	
	@RequestMapping(value = "/board/notice/update", method = RequestMethod.POST)
	public String updatePost(BoardBean bb) {	
		
		boardService.updateNotice(bb);
	
		return "redirect:/board/notice/main";
	}
	
	@RequestMapping(value = "/board/notice/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {	
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		boardService.deleteNotice(num);

		return "redirect:/board/notice/main";
	}

}
