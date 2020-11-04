package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainController {

	@RequestMapping(value = "/outer/main", method= RequestMethod.GET)
	public String main() {
		
		return "/outer/main";
	}
}
