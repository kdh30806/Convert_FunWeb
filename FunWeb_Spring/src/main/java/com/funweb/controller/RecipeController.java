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
import com.funweb.service.RecipeService;

@Controller
public class RecipeController {
	
	@Inject
	private RecipeService recipeService;
	
	@RequestMapping(value = "/board/recipe/main", method = RequestMethod.GET)
	public String main(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		String pageNum = request.getParameter("pageNum");
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		if(pageNum == null) {
			pageNum = "1";
		}
		pb.setPageNum(pageNum);
		
		List<BoardBean> recipeList = recipeService.getBoardList(pb);
		
		pb.setCount(recipeService.getBoardCount());
		
		session.setAttribute("id", id);
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("pb", pb);
		
		return "/board/recipe/main";
	}
	
	@RequestMapping(value = "/board/recipe/write", method = RequestMethod.GET)
	public String write(HttpSession session) {	
		
		String id = (String)session.getAttribute("id");
		session.setAttribute("id", id);
		
		return "/board/recipe/write";
	}
	
	@RequestMapping(value = "/board/recipe/write", method = RequestMethod.POST)
	public String writePost(BoardBean bb) {	
		
		recipeService.writeBoard(bb);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/board/recipe/content", method = RequestMethod.GET)
	public String content(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = recipeService.getBoard(num);
		
		session.setAttribute("id", id);	
		model.addAttribute("bb", bb);
		return "/board/recipe/content";
	}
	
	@RequestMapping(value = "/board/recipe/update", method = RequestMethod.GET)
	public String update(HttpSession session, HttpServletRequest request, Model model) {	
		
		String id = (String)session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardBean bb = recipeService.getBoard(num);
		
		session.setAttribute("id", id);	
		model.addAttribute("bb", bb);
		return "/board/recipe/update";
	}
	
	@RequestMapping(value = "/board/recipe/update", method = RequestMethod.POST)
	public String updatePost(BoardBean bb) {	
		
		recipeService.updateBoard(bb);
	
		return "redirect:/board/recipe/main";
	}
	
	@RequestMapping(value = "/board/recipe/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {	
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		recipeService.deleteBoard(num);

		return "redirect:/board/recipe/main";
	}

}
