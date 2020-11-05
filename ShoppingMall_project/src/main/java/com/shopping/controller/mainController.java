package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainController {

	@RequestMapping(value = "/outer/main", method= RequestMethod.GET)
	public String OUTER_main() {
		
		return "/outer/main";
	}
	
	@RequestMapping(value = "/outer/category", method= RequestMethod.GET)
	public String OUTER_category(HttpServletRequest request, Model model) {
		
		String category = request.getParameter("category");
		
		model.addAttribute("category", category);
		
		return "/outer/category";
	}
}
