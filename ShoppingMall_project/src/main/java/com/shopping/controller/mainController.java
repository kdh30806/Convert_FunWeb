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
	
	@RequestMapping(value = "/top/main", method= RequestMethod.GET)
	public String TOP_main() {
		
		return "/top/main";
	}
	
	@RequestMapping(value = "/top/category", method= RequestMethod.GET)
	public String TOP_category(HttpServletRequest request, Model model) {
		
		String category = request.getParameter("category");
		
		model.addAttribute("category", category);
		
		return "/top/category";
	}
	
	@RequestMapping(value = "/acc/main", method= RequestMethod.GET)
	public String ACC_main() {
		
		return "/acc/main";
	}
	
	@RequestMapping(value = "/acc/category", method= RequestMethod.GET)
	public String ACC_category(HttpServletRequest request, Model model) {
		
		String category = request.getParameter("category");
		
		model.addAttribute("category", category);
		
		return "/acc/category";
	}
	
	@RequestMapping(value = "/bag/main", method= RequestMethod.GET)
	public String BAG_main() {
		
		return "/bag/main";
	}
	
	@RequestMapping(value = "/bag/category", method= RequestMethod.GET)
	public String BAG_category(HttpServletRequest request, Model model) {
		
		String category = request.getParameter("category");
		
		model.addAttribute("category", category);
		
		return "/bag/category";
	}
	
	@RequestMapping(value = "/pants/main", method= RequestMethod.GET)
	public String PANTS_main() {
		
		return "/pants/main";
	}
	
	@RequestMapping(value = "/pants/category", method= RequestMethod.GET)
	public String PANTS_category(HttpServletRequest request, Model model) {
		
		String category = request.getParameter("category");
		
		model.addAttribute("category", category);
		
		return "/pants/category";
	}
	
	@RequestMapping(value = "/shoes/main", method= RequestMethod.GET)
	public String SHOES_main() {
		
		return "/shoes/main";
	}
	
	@RequestMapping(value = "/shoes/category", method= RequestMethod.GET)
	public String SHOES_category(HttpServletRequest request, Model model) {
		
		String category = request.getParameter("category");
		
		model.addAttribute("category", category);
		
		return "/shoes/category";
	}
	
	@RequestMapping(value = "/beauty/main", method= RequestMethod.GET)
	public String BEAUTY_main() {
		
		return "/beauty/main";
	}
}
