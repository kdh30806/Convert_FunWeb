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
		
		List<BoardBean> recipeList = boardService.getHotRecipeList();
		System.out.println(recipeList.get(0).getContent());
		return recipeList;
	}

}
