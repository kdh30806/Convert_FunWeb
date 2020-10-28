package com.funweb.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funweb.domain.BoardBean;
import com.funweb.service.BoardService;

@RestController
public class RestAjaxController {
	
	@Inject
	private BoardService boardService;
	
	@PostMapping("/AJAX_recipeList")
	public List<BoardBean> AJAX_recipeList() {		
		return boardService.getHotRecipeList();
	}
	
	@PostMapping("/AJAX_notice")
	public List<BoardBean> AJAX_noticeList() {	
		List<BoardBean> noticeList = boardService.getNoticeList();
		System.out.println("@@@@@@@@@@@@@@@@@");
		System.out.println(noticeList.get(0).getContent());
		return noticeList;
	}
	
	@PostMapping("/AJAX_picture")
	public List<BoardBean> AJAX_pictureList() {	
		return boardService.getPictureList();
	}

}
